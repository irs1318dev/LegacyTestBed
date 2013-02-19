package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	
	public void robotInit()
	{
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(0);
	}
	
	public void teleopPeriodic()
	{
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedUp()) {
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
			ReferenceData.getInstance().getShooterData().getMotorSetPoint() - 0.0005
					);
//			System.out.println("ShooterCalc: Going up to "+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedDown()) {
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
			ReferenceData.getInstance().getShooterData().getMotorSetPoint() + 0.0005
					);
//			System.out.println("ShooterCalc: Going down to "+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}
		if(ReferenceData.getInstance().getShooterData().getMotorSetPoint() > 0) {
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(0);
//			System.out.println("ShooterCalc: Clipping to 0, actual"+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}

		if(ReferenceData.getInstance().getShooterData().getMotorSetPoint() < -1) {
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(-1);
//			System.out.println("ShooterCalc: Clipping to -1, actual"+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}
	}
		
}
