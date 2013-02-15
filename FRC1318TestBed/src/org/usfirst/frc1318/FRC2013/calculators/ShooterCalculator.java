package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	SettingsLookup shooterSpeed;
	
	public void RobotInit()
	{	
		shooterSpeed = new SettingsLookup();
		ReferenceData.getInstance().getShooterData().setSpeedSettings(shooterSpeed);
		shooterSpeed.addSetting(0);
		shooterSpeed.addSetting(1000);
	}
	
	public void TeleopPeriodic()
	{
		updateSpeed();
	}
	
	private void updateSpeed()
	{
		//respond to button presses
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedUp()) {
			shooterSpeed.up();
		}
		
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedDown()) {
			shooterSpeed.down();
		}
		
		//update data class with speed
		ReferenceData.getInstance().getShooterData().setMotorSpeed(
												shooterSpeed.getCurrent());
	}
	
}
