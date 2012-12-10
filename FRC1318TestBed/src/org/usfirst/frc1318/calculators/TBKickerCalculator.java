package org.usfirst.frc1318.calculators;

import org.usfirst.frc1318.shared.TBGamepadData;
import org.usfirst.frc1318.shared.TBThroughBeamData;
import org.usfirst.frc1318.shared.TBSolenoidData;
import org.usfirst.frc1318.utils.DriverStationPrint;
import org.usfirst.frc1318.components.RobotComponentBase;

public class TBKickerCalculator extends RobotComponentBase
{
	DriverStationPrint driverStationPrint;
	boolean isAutomated;
	long timer;
	final long timeout = 500;
	
	public TBKickerCalculator()
	{
	}

	public void robotInit() {
		driverStationPrint = new DriverStationPrint();
	}
	
	//TODO review logic
	/*
	 * checkToKick()
	 * if manual mode, and kick button is pressed, then kick
	 * else if automated mode, and through beam sensor is trippred, then kick
	 * else if automated mode, and kicker button is pressed, then kick
	 * 
	 * kick()
	 * if kicked, and timer>0, return
	 * else setKicked(true)
	 * 
	 * checkToRetract()
	 * decrement the timer
	 * if timer <=0 set kicker false
	 */
	
	private void checkShouldKick()
	{
		//TODO keep track of old automated value, print out changes
		if(isAutomated) //TODO read the mode button
		{
			if(TBThroughBeamData.get())//insert beam sensor boolean here
			{
				
				TBSolenoidData.setIfKicked(true);
				timer = System.currentTimeMillis()+ timeout;
			}
		}
		if(TBGamepadData.isKickButton())//insert button pressed boolean here
		{
			TBSolenoidData.setIfKicked(true);
			timer = System.currentTimeMillis()+ timeout;
		}
	}
	
	private void checkShouldNotKick()
	{
		if(timer <= System.currentTimeMillis())
		{
			TBSolenoidData.setIfKicked(false);
		}
	}
	
	public void teleopPeriodic()
	{
		if(TBSolenoidData.kicked())
			checkShouldNotKick();
		else
			checkShouldKick();
	}
}