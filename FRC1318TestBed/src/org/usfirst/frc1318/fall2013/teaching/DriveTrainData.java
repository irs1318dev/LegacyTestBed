package org.usfirst.frc1318.fall2013.teaching;

public class DriveTrainData {
	
	private double leftMotorSpeed;
	private double rightMotorSpeed;
	
	private static DriveTrainData data;
	
	private DriveTrainData(){
	}
	
	public static DriveTrainData getInstance(){
		if(data == null){
			data = new DriveTrainData();
		}
		return data;
	}
	
	public double getLeftMotorSpeed() {
		return leftMotorSpeed;
	}
	public void setLeftMotorSpeed(double leftMotorSpeed) {
		if(leftMotorSpeed > 1){
			leftMotorSpeed = 1;
		}else if(leftMotorSpeed < -1){
			leftMotorSpeed = -1;
		}
		this.leftMotorSpeed = leftMotorSpeed;
	}
	public double getRightMotorSpeed() {
		return rightMotorSpeed;
	}
	public void setRightMotorSpeed(double rightMotorSpeed) {
		this.rightMotorSpeed = rightMotorSpeed;
	}
	
	

}
