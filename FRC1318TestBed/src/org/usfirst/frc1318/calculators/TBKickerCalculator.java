package org.usfirst.frc1318.calculators;

import org.usfirst.frc1318.shared.TBGamepadData;
import org.usfirst.frc1318.shared.TBThroughBeamData;
import org.usfirst.frc1318.shared.TBSolenoidData;
import org.usfirst.frc1318.components.RobotComponentBase;

public class TBKickerCalculator extends RobotComponentBase
{
	boolean isAutomated;
	int timer;
	final int timeout = 50;
	
	public TBKickerCalculator()
	{
		
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
		if(isAutomated) //TODO read the mode button
		{
			if(TBThroughBeamData.get())//insert beam sensor boolean here
			{
				//kickKicker();
				TBSolenoidData.setIfKicked(true);
				timer = timeout;
			}
		}
		if(TBGamepadData.isKickButton())//insert button pressed boolean here
		{
			//kickKicker();
			TBSolenoidData.setIfKicked(true);
			timer = timeout;
		}
	}
	
	private void checkShouldNotKick()
	{
		timer -=1; //TODO reset to 0
		if(timer <= 0)
		{
			TBSolenoidData.setIfKicked(false);
			//retractKicker();
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