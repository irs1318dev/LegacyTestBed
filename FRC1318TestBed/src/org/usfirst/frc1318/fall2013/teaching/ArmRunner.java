package org.usfirst.frc1318.fall2013.teaching;

import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class ArmRunner extends RobotComponentBase{

	private Talon upper, lower;

	public void robotInit(){
		upper = getRightTalon();
		lower = getLeftTalon();
	}
	
	public void teleopPeriodic(){
		double upperSetSpeed = ArmData.getInstance().getUpperSpeed();
		upperSetSpeed = Math.max(upperSetSpeed, -1);
		upperSetSpeed = Math.min(upperSetSpeed, 1);
		upper.set(upperSetSpeed);
		
		double lowerSetSpeed = ArmData.getInstance().getLowerSpeed();
		lowerSetSpeed = Math.max(lowerSetSpeed, -1);
		lowerSetSpeed = Math.min(lowerSetSpeed, 1);
		lower.set(lowerSetSpeed);
	}
	
	public Talon getRightTalon(){
		return new Talon(PortRef.SIDECAR, PortRef.LEFT_TALON);
	}
	
	public Talon getLeftTalon(){
		return new Talon(PortRef.SIDECAR, PortRef.RIGHT_TALON);
	}
	
}
