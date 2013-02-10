package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.SpeedController;
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
		System.out.println("Begin teleop");
		double rightVal = ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed();
		System.out.println("\tgot right " + rightVal);
		rightVal = Math.min(rightVal, 1);
		rightVal = Math.max(rightVal, -1);
		//System.out.println("curved right " + rightVal);
		getRightTalon().set(rightVal);
		
		System.out.println("\tDriveTrainRunner 29 Right Value " + rightVal);
		
		double leftVal = ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed();
		System.out.println("\tgot left " + leftVal);
		leftVal = Math.min(leftVal, 1);
		leftVal = Math.max(leftVal, -1);
		//System.out.println("curved left" + leftVal);
		getLeftTalon().set(leftVal);
		
		System.out.println("\tDriveTrainRunner 36 Left Value " + leftVal);
		System.out.println("End teleop");
	}
	
}
