package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class DriveTrainRunner extends RobotComponentBase {
	//two motors
	private Talon rightTalon, leftTalon;
	
	//read speed from a data class and update
	
	public void robotInit(){
		System.out.println("yeah this should never be called. if it is stuff is broke (for tests)");
		rightTalon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_R);
		leftTalon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_L);
	}

	public Talon getRightTalon() {
		return rightTalon;
	}
	
	public Talon getLeftTalon() {
		return leftTalon;
	}
	
	public void teleopPeriodic(){
		double rightVal = ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed();
		rightVal = Math.min(rightVal, 1);
		rightVal = Math.max(rightVal, -1);
		getRightTalon().set(rightVal);
				
		double leftVal = ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed();
		leftVal = Math.min(leftVal, 1);
		leftVal = Math.max(leftVal, -1);
		getLeftTalon().set(leftVal);
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
//public class DriveTrainRunner extends RobotComponentBase {
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
//		getRightTalon().set(ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed());
//				
//		getLeftTalon().set(ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed());
//	}
//	
//}
