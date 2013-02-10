package org.usfirst.frc1318.FRC2013.shared;

public class DriveTrainData {
	
	private double rightEncoder;
	private double leftEncoder;
	private double rightSpeedSetPoint, leftSpeedSetPoint;	//read from joystick
															//-1 to +1 
	private double rightPIDSpeed, leftPIDSpeed;
	
	public double getRightSpeedSetPoint(){
		return rightSpeedSetPoint;
	}
	
	public void setRightSpeedSetPoint(double val){
		rightSpeedSetPoint = val;
	}
	
	public double getLeftSpeedSetPoint(){
		return leftSpeedSetPoint;
	}
	
	public void setLeftSpeedSetPoint(double val){
		leftSpeedSetPoint = val;
	}
	
	public double getRightPIDSpeed(){
		return rightPIDSpeed;
	}
	
	public void setRightPIDSpeed(double val){
		rightPIDSpeed = val;
		System.out.println("Set right PID to " + val);
	}
	
	public double getLeftPIDSpeed(){
		return leftPIDSpeed;
	}
	
	public void setLeftPIDSpeed(double val){
		leftPIDSpeed = val;
		System.out.println("Set left PID to " + val);
	}
	
	public double getRightEncoder(){
		return rightEncoder;
	}
	
	public void setRightEncoder(double val){
		rightEncoder = val;
	}
	
	public double getLeftEncoder(){
		return leftEncoder;
	}
	
	public void setLeftEncoder(double val){
		leftEncoder = val;
	}
}