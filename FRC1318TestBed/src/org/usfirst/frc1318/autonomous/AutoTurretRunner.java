package org.usfirst.frc1318.autonomous;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.calculators.MMCalculator;
import org.usfirst.frc1318.minimike.shared.MMGamePadData;
import org.usfirst.frc1318.minimike.shared.MMLimitSwitchData;
import org.usfirst.frc1318.minimike.shared.MMTurretData;
import org.usfirst.frc1318.utils.DriverStationPrint;
import org.usfirst.frc1318.minimike.shared.MMReferenceData;

import java.util.Vector;
import edu.wpi.first.wpilibj.Timer;

public class AutoTurretRunner extends RobotComponentBase{

	private int currentState = 0; // Current state of state machine. 0 - init, 1 - calibrate, 2 - find center.
	public static final int samples = 3; // number of samples that the turret uses to find the center.
	
	private Vector intervals; // the longs that represent the distance between each side hit.
	private boolean isLeft; // is the turret on the left?
	long init; // the value for the start of the final movement for the turret
	
	public void robotInit() 
	{
		intervals = new Vector();
		isLeft = false;
	}	
	public void teleopPeriodic() 
	{
		switch(currentState)
		{
		case 0:
			AutoTurretInit();
			break;
		case 1:
			AutoTurretCalibrate();
			break;
		case 2:
			AutoTurretFindCenter();
			break;
		default:
			break;
		}
	}
	
	boolean isInit = false; // get rid of this, it is sketchy.
	
	private void AutoTurretInit()
	{// turns left until the left limit switch is hit
		if(!MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState())
		{
			MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(-MMCalculator.SPEED);
		}
		else
		{
			isLeft = true;
			intervals.addElement(Timer.getUsClock()); // perhaps find a way to position at the beginning of calibration for smaller gap?
			currentState = 1;
		}
	}
	private void AutoTurretCalibrate()
	{
		if(isLeft)
		{
			if(!MMReferenceData.getInstance().getMMLimitSwitchData().getRightState())
			{
				MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(MMCalculator.SPEED);
			}
			else
			{
				intervals.addElement(Timer.getUsClock());
				isLeft = false;
			}
		}
		else
		{
			if(!MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState())
			{
				MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(-MMCalculator.SPEED);
			}
			else
			{
				intervals.addElement(Timer.getUsClock());
				isLeft = true;
			}
		}
		if(intervals.size() > samples)
			currentState = 2;
	}
	private void AutoTurretFindCenter()
	{//locates the center based on the longs you found
		if(!isInit)
		{
			init = Timer.getUsClock();
			isInit = true;;
		}
		if(Timer.getUsClock() < (init + getAverage(intervals)))
		{
			MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(-MMCalculator.SPEED);
		}
		else
		{
			currentState = 3;
		}
	}
	
	public static long getAverage(Vector intervals)
	{// finds the average of the longs in the vector that is passed in.
		long total = 0;
		for(int i = 0; i < intervals.size() - 1; i++)
		{
			total += ((long)intervals.elementAt(i + 1)) - ((long)intervals.elementAt(i));
		}
		return (total / intervals.size());
	}
}
