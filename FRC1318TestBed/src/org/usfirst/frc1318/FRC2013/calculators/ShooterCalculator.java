package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	SettingsLookup shooterSpeed;
	
	public void RobotInit()
	{
		shooterSpeed.addSetting(0);
	}
	
	public void TeleopPeriodic()
	{
		updateAngle();
		updateSpeed();
	}
	
	private void updateAngle()
	{
		//set angle based on buttons
			//if button pressed
			//ShooterData.setShooterAngle(ShooterData.constants.SHOOTER_UP);
			//if button pressed
			//ShooterData.setShooterAngle(ShooterData.constants.SHOOTER_DOWN);
	}
	
	private void updateSpeed()
	{
		//calculate motor speed
			//calculate somehow
			//set value in data class
	}
	
}
