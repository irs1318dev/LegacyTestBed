package org.usfirst.frc1318.fall2013.teaching;

public class ArmData {

	private double lowerSpeed, upperSpeed;
	
	private static ArmData data;
	
	private ArmData(){
	}
	
	public static ArmData getInstance(){
		if(data == null){
			data = new ArmData();
		}
		return data;
	}

	public double getLowerSpeed() {
		return lowerSpeed;
	}

	public void setLowerSpeed(double rightSpeed) {
		this.lowerSpeed = rightSpeed;
	}

	public double getUpperSpeed() {
		return upperSpeed;
	}

	public void setUpperSpeed(double leftSpeed) {
		this.upperSpeed = leftSpeed;
	}
	
	
	
}
