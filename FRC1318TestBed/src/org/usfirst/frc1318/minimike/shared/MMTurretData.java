package org.usfirst.frc1318.minimike.shared;

public class MMTurretData {
	static double turnSpeed = 0;
	
	//speed must have a value between 1 and -1
	public static void setTurnSpeed(double speed){
		turnSpeed = speed;
	}
	
	public static double getTurnSpeed(){
		return turnSpeed;
	}
	
}
