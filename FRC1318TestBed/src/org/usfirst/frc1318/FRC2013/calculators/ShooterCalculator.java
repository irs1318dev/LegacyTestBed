package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	
	public void robotInit()
	{
		ReferenceData.getInstance().getLookUpTable().setCurrentState(0);
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(
				ReferenceData.getInstance().getLookUpTable().getValue()
				);
	}
	
	boolean lastUpCommand = false;
	boolean lastDownCommand = false;
	
	public void teleopPeriodic()
	{
		System.out.println("***Shooter speed: " + ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		boolean currentUpCommand = ReferenceData.getInstance().getUserInputData().getShooterSpeedUp();
		if (currentUpCommand && !lastUpCommand) { // do once every change
			lastUpCommand = currentUpCommand;
			ReferenceData.getInstance().getLookUpTable().upSpeed();
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
					ReferenceData.getInstance().getLookUpTable().getValue()
					);
			System.out.println("ShooterCalc: Going up to "+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		} else if (!currentUpCommand && lastUpCommand){
			lastUpCommand = currentUpCommand;
		}
		boolean currentDownCommand = ReferenceData.getInstance().getUserInputData().getShooterSpeedDown();
		if (currentDownCommand && !lastDownCommand) { // do once every change
			lastDownCommand = currentDownCommand;
			ReferenceData.getInstance().getLookUpTable().downSpeed();
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
					ReferenceData.getInstance().getLookUpTable().getValue()
					);
			System.out.println("ShooterCalc: Going down to "+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		} else if (!currentDownCommand && lastDownCommand){
			lastDownCommand = currentDownCommand;
		}
		
		
/*		
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedUp()) {
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
					ReferenceData.getInstance().getShooterData().getMotorSetPoint() - .005
				);
//			System.out.println("ShooterCalc: Going up to "+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}
		if(ReferenceData.getInstance().getUserInputData().getShooterSpeedDown() &&
		   ReferenceData.getInstance().getShooterData().getMotorSetPoint() < 0) {
			ReferenceData.getInstance().getLookUpTable().downSpeed();
//			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
//			ReferenceData.getInstance().getLookUpTable().getValue()
//					);
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(
					ReferenceData.getInstance().getShooterData().getMotorSetPoint() + .005
				);
//			System.out.println("ShooterCalc: Going down to "+ ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}
		*/
	}
		
}
