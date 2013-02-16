package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;

public class DriveTrainEncoderReader extends RobotComponentBase{
	
	EncoderAngularVelocity encoderR;
	EncoderAngularVelocity encoderL;
	
	public void robotInit(){
		encoderR = new EncoderAngularVelocity(PortRef.ENCODER_R_A, PortRef.ENCODER_R_B);
		encoderL = new EncoderAngularVelocity(PortRef.ENCODER_L_A, PortRef.ENCODER_L_B);
		//TODO check inputs
	}
	
	public void teleopPeriodic(){

		ReferenceData.getInstance().getDriveTrainData().setRightEncoder(encoderR.getRate());
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoder(encoderL.getRate());
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(encoderR.getDistance());
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(encoderL.getDistance());
		
		//TODO check encoder call
	}
	
	public void setEncoders(EncoderAngularVelocity eR, EncoderAngularVelocity eL){
		encoderR = eR;
		encoderL = eL;
	}

}
 