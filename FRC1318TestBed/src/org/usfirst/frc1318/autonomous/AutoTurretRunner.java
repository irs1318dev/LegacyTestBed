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
	public static final int samples = 2; // number of samples that the turret uses to find the center.
	
	private Vector intervals; // the longs that represent the distance between each side hit.
	private boolean isLeft = false; // is the turret on the left?
	
	public void robotInit() 
	{
		System.out.println("RAN THE INIT FOR AUTOTURRET!");
		intervals = new Vector();
		isLeft = false;
	}	
	public void teleopPeriodic() 
	{
//		System.out.println("tPer auto");
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
		
		System.out.println("getLeftState = " + MMReferenceData.getInstance().getMMLimitSwitchData().getRightState());
		if(!MMReferenceData.getInstance().getMMLimitSwitchData().getRightState())
		{
			System.out.println("Moving Left - AutoTurretInit");
			MMReferenceData.getInstance().getMMGamePadData().setLeftButton(true);
			MMReferenceData.getInstance().getMMGamePadData().setRightButton(false);
		}
		else
		{
			System.out.println("HIT LEFT");
			isLeft = true;
			//intervals.addElement(Timer.getUsClock()); // perhaps find a way to position at the beginning of calibration for smaller gap?
			currentState = 1;
			MMReferenceData.getInstance().getMMGamePadData().setLeftButton(false);
			MMReferenceData.getInstance().getMMGamePadData().setRightButton(false);
		}
	}

	private boolean isComplete=false;
	
	private void AutoTurretCalibrate()
	{//CASE 1
		if(intervals.size() == 0) // starts if the start has not occured yet
		{
			intervals.addElement(new Interval());
			((Interval)intervals.elementAt(intervals.size() - 1)).start(System.currentTimeMillis());
			isComplete = false;
			System.out.println("Start interval");
		}
		if(isLeft) // this actually sends it to the right
		{System.out.println("Moving Right - AutoTurretCalibrate");
			if(!MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState())
			{
				MMReferenceData.getInstance().getMMGamePadData().setLeftButton(false);
				MMReferenceData.getInstance().getMMGamePadData().setRightButton(true);
			}
			else
			{
   				((Interval)intervals.elementAt(intervals.size()-1)).end(System.currentTimeMillis());

				if(intervals.size() < samples)
				{
					intervals.addElement(new Interval());
					((Interval)intervals.elementAt(intervals.size() - 1)).start(System.currentTimeMillis());
					System.out.println("Complete move right");
					
				} 
				isLeft = false;
				MMReferenceData.getInstance().getMMGamePadData().setLeftButton(false);
				MMReferenceData.getInstance().getMMGamePadData().setRightButton(false);
			}
		}
		else // this actually sends it to the left
		{System.out.println("Moving Left - AutoTurretCalibrate");
			if(!MMReferenceData.getInstance().getMMLimitSwitchData().getRightState())
			{
				MMReferenceData.getInstance().getMMGamePadData().setLeftButton(true);
				MMReferenceData.getInstance().getMMGamePadData().setRightButton(false);
			}
			else
			{
				((Interval)intervals.elementAt(intervals.size()-1)).end(System.currentTimeMillis());
				if (intervals.size() == samples) {
				    isComplete = true;
					System.out.println("Complete");
				}
				if(intervals.size() < samples)
				{
					intervals.addElement(new Interval());
					((Interval)intervals.elementAt(intervals.size() - 1)).start(System.currentTimeMillis());
					System.out.println("Complete move left");
				}
				isLeft = true;
				MMReferenceData.getInstance().getMMGamePadData().setLeftButton(false);
				MMReferenceData.getInstance().getMMGamePadData().setRightButton(false);
			}
		}
		if (isComplete) {
			currentState = 2;
		}
	}
	
	long averageIntervalTime = 0;
	long stopTime = 0;
	private void AutoTurretFindCenter()
	{//CASE 2 locates the center based on the longs you found
		if(stopTime==0)
		{
			averageIntervalTime = getAverage(intervals) / 2;
			stopTime = System.currentTimeMillis() + averageIntervalTime;
			System.out.println("averageIntervalTime= " + averageIntervalTime);
		}
		if(System.currentTimeMillis() < stopTime)
		{
			MMReferenceData.getInstance().getMMGamePadData().setLeftButton(false);
			MMReferenceData.getInstance().getMMGamePadData().setRightButton(true);
		}
		else
		{
			MMReferenceData.getInstance().getMMGamePadData().setLeftButton(false);
			MMReferenceData.getInstance().getMMGamePadData().setRightButton(false);
			currentState = 3;
			System.out.println("We are at center ");
		}
	}
	
	public static long getAverage(Vector intervals)
	{// finds the average of the longs in the vector that is passed in.
		long total = 0;
		for(int i = 0; i < intervals.size(); i++)
		{
			total += ((Interval)intervals.elementAt(i)).getDifference();
		}
		System.out.println("Total="+total+", intervals="+intervals.size());
		return (total / intervals.size());
	}
}
