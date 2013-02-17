package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.PID;

public class ShooterPIDCalculator extends RobotComponentBase {
	PID shooterPID;
	long count;
	
	public void robotInit()
	{	
		shooterPID = new PID(1,1,1);//TODO adjust values
		shooterPID.setKFade(.75);
	}
	
	public void teleopPeriodic()
	{
		double shooterSet =ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint();
		double shooterEncv = ReferenceData.getInstance().getDriveTrainData().getLeftEncoder();
		double shooterKf = 1;
		double shooterKd = 0.0;
		double shooterKscale = 20000;

		double shooterPIDVal = shooterKf * shooterSet + shooterKd*(shooterKscale * shooterSet - shooterEncv);

		if (count%10==0) { 
			System.out.println("shooterSet="+shooterSet+", shooterEncv="+shooterEncv+", shooterPID="+shooterPIDVal);
		}
		count++;
		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());

//		shooterPID.setSetpoint(ReferenceData.getInstance().getShooterData().getMotorSetPoint());
//		shooterPID.input(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity());
//		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());
	}
	
}
