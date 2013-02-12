package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	SettingsLookup shooterSpeed;
	ShooterData shooterData;
	
	public void RobotInit()
	{
		shooterData = ReferenceData.getInstance().getShooterData();
		
		shooterSpeed = new SettingsLookup();
		ReferenceData.getInstance().getShooterData().setSpeedSettings(shooterSpeed);
		shooterSpeed.addSetting(0);
		shooterSpeed.addSetting(1000);
	}
	
	public void TeleopPeriodic()
	{
		updateAngle();
		updateSpeed();
	}
	
	private void updateAngle()
	{
		//set angle in data class based on buttons
		if(ReferenceData.getInstance().getJoystickData().getShooterDown()) {
			shooterData.setShooterAngle(ShooterData.constants.SHOOTER_DOWN);
		}else if(ReferenceData.getInstance().getJoystickData().getShooterUp()) {
			shooterData.setShooterAngle(ShooterData.constants.SHOOTER_UP);
		}
		
		
	}
	
	private void updateSpeed()
	{
		//respond to button presses
		if(ReferenceData.getInstance().getJoystickData().getShooterSpeedUp()) {
			shooterSpeed.up();
		}
		
		if(ReferenceData.getInstance().getJoystickData().getShooterSpeedDown()) {
			shooterSpeed.down();
		}
		
		//update data class with speed
		ReferenceData.getInstance().getShooterData().setMotorSpeed(
												shooterSpeed.getCurrent());
	}
	
}
