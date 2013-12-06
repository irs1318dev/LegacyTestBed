package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.legoarmbot.shared.constants.PortRef;
import org.usfirst.frc1318.legoarmbot.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class ArmMotorRunner extends RobotComponentBase {
	//two motors
	private Talon theta1Talon, theta2Talon;
	
	//read speed from a data class and update
	
	public void robotInit(){
		theta1Talon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_THETA1);
		theta2Talon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_THETA2);
	}

	public Talon getRightTalon() {
		return theta1Talon;
	}
	
	public Talon getLeftTalon() {
		return theta2Talon;
	}

	int count=0;
	
	public void teleopPeriodic(){
		double rightVal = ReferenceData.getInstance().getArmData().getTheta1PIDSpeed();
		rightVal = Math.min(rightVal, 1);
		rightVal = Math.max(rightVal, -1);
		getRightTalon().set(rightVal);
				
		double leftVal = ReferenceData.getInstance().getArmData().getTheta2PIDSpeed();
		leftVal = Math.min(leftVal, 1);
		leftVal = Math.max(leftVal, -1);
		getLeftTalon().set(leftVal);

		count++;
		if (count%500==0) {
			System.out.println("leftTalon="+getLeftTalon().get()+", rightTalon="+getRightTalon().get());
			count=0;
		}

	}
}	


//package org.usfirst.frc1318.FRC2013.runners;
//
//import org.usfirst.frc1318.FRC2013.reference.PortRef;
//import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
//import org.usfirst.frc1318.components.RobotComponentBase;
//
//import edu.wpi.first.wpilibj.Talon;
//
//public class ArmRunner extends RobotComponentBase {
//	//two motors
//	private Talon rightTalon, leftTalon;
//	
//	//read speed from a data class and update
//	
//	public void robotInit(){
//		rightTalon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_R);
//		leftTalon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_L);
//	}
//
//	public Talon getRightTalon() {
//		return rightTalon;
//	}
//	
//	public Talon getLeftTalon() {
//		return leftTalon;
//	}
//	
//	public void teleopPeriodic(){
//		getRightTalon().set(ReferenceData.getInstance().getArmData().getRightPIDSpeed());
//				
//		getLeftTalon().set(ReferenceData.getInstance().getArmData().getLeftPIDSpeed());
//	}
//	
//}
