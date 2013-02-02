package org.usfirst.frc1318.minimike.shared;

public class MMTurretData {
	private double turnSpeed = 0;
	
	//speed must have a value between 1 and -1
	
	public void setTurnSpeed(double speed){
		turnSpeed = speed;
	}
	
	public double getTurnSpeed(){
		return turnSpeed;
	}
	
}
