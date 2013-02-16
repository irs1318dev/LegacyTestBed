package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	
	public void robotInit()
	{
		
	}
	
	public void teleopPeriodic()
	{
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedUp()) {
			ReferenceData.getInstance().getShooterData().setMotorSpeed(
			ReferenceData.getInstance().getShooterData().getMotorSpeed() - 0.005
					);
		}
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedDown()) {
			ReferenceData.getInstance().getShooterData().setMotorSpeed(
			ReferenceData.getInstance().getShooterData().getMotorSpeed() + 0.005
					);
		}
		if(ReferenceData.getInstance().getShooterData().getMotorSpeed() > 0)
			ReferenceData.getInstance().getShooterData().setMotorSpeed(0);

		if(ReferenceData.getInstance().getShooterData().getMotorSpeed() < -1)
			ReferenceData.getInstance().getShooterData().setMotorSpeed(-1);
	}
	
	private void updateSpeed()
	{
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedUp()) {
			ReferenceData.getInstance().getShooterData().getSpeedSettings().up();
		}
		
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedDown()) {
			ReferenceData.getInstance().getShooterData().getSpeedSettings().down();
		}
		
		//update data class with speed
		ReferenceData.getInstance().getShooterData().setMotorSpeed(
				ReferenceData.getInstance().getShooterData().getSpeedSettings().getCurrent());
	}
	
}
