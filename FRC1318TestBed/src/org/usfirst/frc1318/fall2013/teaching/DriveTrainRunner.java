package org.usfirst.frc1318.fall2013.teaching;

import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class DriveTrainRunner extends RobotComponentBase{
	
	private Talon rightTalon, leftTalon;
	
	public void robotInit(){
		rightTalon = new Talon(PortRef.SIDECAR, PortRef.RIGHT_TALON);
		leftTalon = new Talon(PortRef.SIDECAR, PortRef.LEFT_TALON);
		//object.method(arguments);
	}
	
	public void teleopPeriodic(){
		double rightVal = DriveTrainData.getInstance().getRightMotorSpeed();
		rightVal = Math.min(rightVal, 1);
		rightVal = Math.max(rightVal, -1);
		getRightTalon().set(rightVal);
		
		double leftVal = DriveTrainData.getInstance().getLeftMotorSpeed();
		leftVal = Math.min(leftVal, 1);
		leftVal = Math.max(leftVal, -1);
 		getLeftTalon().set(leftVal);
	}
	
	public Talon getRightTalon(){
		return rightTalon;
	}
	
	public Talon getLeftTalon(){
		return leftTalon;
	}
	
	public int add(int x, int y){
		return x + y;
	}
	

}
