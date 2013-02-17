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
		encoderR.setName("RightMotor");
		encoderL = new EncoderAngularVelocity(PortRef.ENCODER_L_A, PortRef.ENCODER_L_B);
		encoderL.setName("LeftMotor");
	}
	
	double count;
	
	public void teleopPeriodic(){

		double rencv = encoderR.getRate();
		double lencv = encoderL.getRate();
		
//		if (count%10000==0) {
//			System.out.println("rawLencv="+lencv+", rawRencv="+rencv);
//		}
		ReferenceData.getInstance().getDriveTrainData().setRightEncoder(encoderR.getRate());
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoder(encoderL.getRate());
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(encoderR.getDistance());
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(encoderL.getDistance());
		
//		System.out.println("LEV="+ReferenceData.getInstance().getDriveTrainData().getLeftEncoder()
//				+", REV="+ReferenceData.getInstance().getDriveTrainData().getRightEncoder()
//				);
		//TODO check encoder call
	}
	
	public void setEncoders(EncoderAngularVelocity eR, EncoderAngularVelocity eL){
		encoderR = eR;
		encoderL = eL;
	}

}
 