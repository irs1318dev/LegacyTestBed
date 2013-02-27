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
		shooterPID = new PID(-0.0004 ,0.0, 0.0 , 1);//TODO adjust values
		shooterPID.setKFade(0.75);
		shooterPID.setClampRange(-1, 1);
		shooterPID.setKScale(25000);
	}
	
	double shooterKf = 1.0;
	double shooterKd = -0.0005;

	public void teleopPeriodic()
	{
//		double shooterSet =ReferenceData.getInstance().getShooterData().getMotorSetPoint();
//		double shooterEncv = ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity();
//		
//		double shooterKscale = 20000;
//		double shooterKf = 0.25;
//		double shooterKd = 0.0005;
//		
//		double shooterPIDVal = shooterKf * shooterSet + shooterKd*(shooterKscale * shooterSet - shooterEncv);
//
//		if (count%100000==0) { 
//			
//			System.out.println("shooterSet="+shooterSet+", shooterEncv="+shooterEncv+", shooterPID="+shooterPIDVal);
//		}
//		count++;
//		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPIDVal);

		
		double angularVelocity = ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity();
		shooterPID.setSetpoint(ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		shooterPID.input(angularVelocity);
		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());
		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());
		
	}
	
}
