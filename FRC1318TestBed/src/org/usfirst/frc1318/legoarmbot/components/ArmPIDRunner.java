package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.legoarmbot.shared.ReferenceData;
import org.usfirst.frc1318.legoarmbot.shared.constants.RobotValues;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.JoystickFilter;
import org.usfirst.frc1318.generic.controllers.PID;

public class ArmPIDRunner extends RobotComponentBase{
	
	//TODO wright test
	
//	PID theta1PID;
//	PID theta2PID;
	long count;
	
	public void robotInit(){
////		rightPID = new PID(0, 0, 0, 1);
//		//flip sign if not work right after pull
//		theta1PID = new PID(0, 0, -0.001, 0);
////		rightPID = new PID(0, 0, 0.0, 0);
//		theta1PID.setKScale(2800); 
//		
////		all theta2 negative
////		theta2PID = new PID(0, 0, 0, -1);
//		theta2PID = new PID(0, 0, -0.001, 0);
////		theta2PID = new PID(0, 0, 0.0, 0);
//		theta2PID.setKScale(2800);
//		//TODO ask James about values
//		count = 0;
	}
	
	public void teleopPeriodic(){
		
		double theta1SetPoint =ReferenceData.getInstance().getArmData().getTheta1PositionSetPoint();
		double theta1EncV = ReferenceData.getInstance().getArmData().getTheta1Encoder();
		double theta1PIDVal = RobotValues.THETA1_KP * (theta1SetPoint - theta1EncV);
		
		double theta2SetPoint =ReferenceData.getInstance().getArmData().getTheta2PositionSetPoint();
		double theta2EncV = ReferenceData.getInstance().getArmData().getTheta2Encoder();
		double theta2PIDVal = RobotValues.THETA2_KP * (theta2SetPoint - theta2EncV);

		JoystickFilter.Speed motorSpeed = new JoystickFilter.Speed();
		motorSpeed.speedL = theta2PIDVal;
		motorSpeed.speedR = theta1PIDVal;
//		JoystickFilter.Speed clampedSpeed = JoystickFilter.applyClamp(motorSpeed, 1.0);
		
		if (count%500==0) {
			System.out.println("theta2SetPoint="+theta2SetPoint+" , theta1SetPoint="+theta1SetPoint);
			System.out.println("theta2EncV="+theta2EncV+" , theta1EncV="+theta1EncV);
			System.out.println("Theta2PID="+ReferenceData.getInstance().getArmData().getTheta2PIDSpeed()
					+", Theta1PID="+ReferenceData.getInstance().getArmData().getTheta1PIDSpeed()
					);
//			System.out.println("lmotor="+clampedSpeed.speedL+" , rmotor="+clampedSpeed.speedR);
		}
		count++;

		ReferenceData.getInstance().getArmData().setTheta1PIDSpeed(theta1PIDVal);
		ReferenceData.getInstance().getArmData().setTheta2PIDSpeed(theta2PIDVal);

//		ReferenceData.getInstance().getArmData().setTheta1PIDSpeed(clampedSpeed.speedR);
//		ReferenceData.getInstance().getArmData().settheta2PIDSpeed(clampedSpeed.speedL);

//		System.out.println("LPIDConst:"+theta2PID.toString()
//				+", RPIDConst:"+rightPID.toString()
//				);

	}
	
	//PID.setSetpoint(what you want the encoder to read = what the joystick says it should read) 
	//PID.input(acutal angular velocity)
	//PID.getOutPut() = value to give motors 
}
