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
	private boolean isLeft = false; // is the turret on the left?
	private int cycles = 0;
	long init = -1; // the value for the start of the final movement for the turret
	private long localTimer = 0;
	
	public void robotInit() 
	{
		intervals = new Vector();
		isLeft = false;
	}	
	public void teleopPeriodic() 
	{
		localTimer++;
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
	
	private void AutoTurretInit()
	{// CASE 0 turns left until the left limit switch is hit
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
	{//CASE 1
		if(intervals.size() == 0) // starts if the start has not occured yet
		{
			intervals.addElement(new Interval());
			((Interval)intervals.elementAt(intervals.size() - 1)).start(localTimer);
		}
		if(isLeft) // this actually sends it to the right
		{
			if(!MMReferenceData.getInstance().getMMLimitSwitchData().getRightState())
			{
				MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(MMCalculator.SPEED);
			}
			else
			{
				((Interval)intervals.elementAt(cycles)).end(localTimer);
				if(!(intervals.size() > samples))
				{
					intervals.addElement(new Interval());
					((Interval)intervals.elementAt(intervals.size() - 1)).start(localTimer);
				}
				isLeft = false;
			}
		}
		else // this actually sends it to the left
		{
			if(!MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState())
			{
				MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(-MMCalculator.SPEED);
			}
			else
			{
				((Interval)intervals.elementAt(cycles)).end(localTimer);
				if(!(intervals.size() > samples))
				{
					intervals.addElement(new Interval());
					((Interval)intervals.elementAt(intervals.size() - 1)).start(localTimer);
				}
				isLeft = true;
			}
		}
		if(intervals.size() > samples)
			currentState = 2;
	}
	private void AutoTurretFindCenter()
	{//CASE 3locates the center based on the longs you found
		if(init == -1)
		{
			init = localTimer;
		}
		if(localTimer < (init + getAverage(intervals) / 2))
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
			total += ((Interval)intervals.elementAt(i)).getDifference();
		}
		return (total / intervals.size());
	}
}
