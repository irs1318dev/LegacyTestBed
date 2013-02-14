package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class DriveTrainRunner extends RobotComponentBase {
	//two motors
	private Talon rightTalon, leftTalon;
	
	//read speed from a data class and update
	
	public void robotInit(){
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
		getRightTalon().set(ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed());
				
		getLeftTalon().set(ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed());
	}
	
}
