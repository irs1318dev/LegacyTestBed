package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.legoarmbot.shared.constants.PortRef;
import org.usfirst.frc1318.legoarmbot.shared.constants.RobotValues;
import org.usfirst.frc1318.legoarmbot.shared.Configuration;
import org.usfirst.frc1318.legoarmbot.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;

import edu.wpi.first.wpilibj.Encoder;

public class ArmEncoderReader extends RobotComponentBase{
	
	Encoder encoder1;
	Encoder encoder2;
	
	public void robotInit(){
		encoder1 = new Encoder(PortRef.ENCODER_1_A, PortRef.ENCODER_1_B);
		encoder2 = new Encoder(PortRef.ENCODER_2_A, PortRef.ENCODER_2_B);
	}
	
	int count;
	
	public void teleopPeriodic(){
		
//		if (count%10000==0) {
//			System.out.println("rawLencv="+lencv+", rawRencv="+rencv);
//		}
		double encoder1Distance = encoder1.getDistance();
		double encoder2Distance = encoder2.getDistance();
		
		ReferenceData.getInstance().getArmData().setCurrentConfiguration(new Configuration(
				encoderDistanceToTheta(encoder1Distance), 
				encoderDistanceToTheta(encoder2Distance), 
				RobotValues.LENGTH_LINK1, 
				RobotValues.LENGTH_LINK2));
		
		ReferenceData.getInstance().getArmData().setTheta1Encoder(encoder1.getRaw());
		ReferenceData.getInstance().getArmData().setTheta2Encoder(encoder2.getRaw());
		ReferenceData.getInstance().getArmData().setTheta1EncoderTicks(encoder1Distance);
		ReferenceData.getInstance().getArmData().setTheta2EncoderTicks(encoder2Distance);
		
		count++;
		if (count%500==0) {
			System.out.println("encoder1Raw="+
					ReferenceData.getInstance().getArmData().getTheta1Encoder()
					+", encoder2Raw="+
					ReferenceData.getInstance().getArmData().getTheta2Encoder()
					);
			System.out.println("encoder1Dist="+encoder1Distance+", encoder2Dist="+encoder2Distance);
			count=0;
		}
	}
	
	public void setEncoders(Encoder eR, Encoder eL){
		encoder1 = eR;
		encoder2 = eL;
	}
	
	private double encoderDistanceToTheta(double encoderDistance) {
		//TODO
		return encoderDistance;
	}

}
 