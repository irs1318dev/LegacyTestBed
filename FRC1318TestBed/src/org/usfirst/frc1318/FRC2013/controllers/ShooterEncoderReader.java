package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;

public class ShooterEncoderReader extends RobotComponentBase{
	
	EncoderAngularVelocity encoderShooter;
	double count;
	
	public void robotInit(){
		encoderShooter = new EncoderAngularVelocity(PortRef.SHOOTER_ENCODER_A, PortRef.SHOOTER_ENCODER_B);
		encoderShooter.setName("ShooterMotor");
	}
	
	public void teleopPeriodic(){

		double shooterEncv = encoderShooter.getRate();
		//System.out.println("Encoder value: " + shooterEncv);
		ReferenceData.getInstance().getShooterData().setEncoderAngularVelocity(shooterEncv);
		ReferenceData.getInstance().getShooterData().setEncoderTicks(encoderShooter.getValue());
//		if (count%100000==0) {
//			System.out.println("shooterEncv="+shooterEncv);
//		}
//		count++;

	}
	
	public void setEncoders(EncoderAngularVelocity eShooter){
		encoderShooter = eShooter;
	}

}
 