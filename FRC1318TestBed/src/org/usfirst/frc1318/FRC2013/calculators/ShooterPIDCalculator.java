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
	
	double lastShooterAngVel = 0.0;

	public void teleopPeriodic()
	{
		double shooterSet =ReferenceData.getInstance().getShooterData().getMotorSetPoint();
		double shooterEncV = ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity();		
//		if (Math.abs(shooterEncV - lastShooterAngVel) > 500) {
//			System.out.println("*********BAD***********");
//			System.out.println("   shooterSet="+shooterSet+", shooterEncv="+shooterEncV +", lastShooterEnc="+lastShooterAngVel);
//			System.out.println("   shooter speed = " + shooterPID.getOutput());
//		}
		
		// fading memory filter to smooth out velocity
		shooterEncV = 0.3 * shooterEncV + 0.7 * lastShooterAngVel;
		
		double shooterKscale = 25000;
		double shooterKf = 0.25;
		double shooterKd = 0.0005;
	
		double shooterPIDVal = shooterKf * shooterSet + shooterKd*(shooterKscale * shooterSet - shooterEncV);
		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPIDVal);
		
		System.out.println("Shooter speed: " + ReferenceData.getInstance().getShooterData().getMotorSpeed());
		System.out.println("Shooter set point: " + ReferenceData.getInstance().getShooterData().getMotorSetPoint());


//		if (count%5==0) { 			
//			System.out.println("shooterSet="+shooterSet+", shooterEncv="+shooterEncV +", lastShooterEnc="+lastShooterAngVel+", shooterPID="+shooterPIDVal);
//			System.out.println("shooter speed = " + shooterPID.getOutput());
//		}
//		count++;

		lastShooterAngVel = shooterEncV;
		
		
//		double angularVelocity = ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity();
//		shooterPID.setSetpoint(ReferenceData.getInstance().getShooterData().getMotorSetPoint());
//		shooterPID.input(angularVelocity);
//		
//		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());
//		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());
		
	}
	
}
