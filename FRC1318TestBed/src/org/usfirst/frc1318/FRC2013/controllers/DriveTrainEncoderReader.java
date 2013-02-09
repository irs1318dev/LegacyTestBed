package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;

public class DriveTrainEncoderReader extends RobotComponentBase{
	
	EncoderAngularVelocity encoderR;
	EncoderAngularVelocity encoderL;
	
	public void robotInit(){
		encoderR = new EncoderAngularVelocity(PortRef.SIDECAR_SLOT, PortRef.ENCODER_R);
		encoderL = new EncoderAngularVelocity(PortRef.SIDECAR_SLOT, PortRef.ENCODER_L);
		//TODO check inputs
	}
	
	public void teleopPeriodic(){

		ReferenceData.getInstance().getDriveTrainData().setRightEncoder(encoderR.getValue());
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoder(encoderL.getValue());
		
		//TODO check encoder call
	}
	
	public void setEncoders(EncoderAngularVelocity eR, EncoderAngularVelocity eL){
		encoderR = eR;
		encoderL = eL;
	}

}
 