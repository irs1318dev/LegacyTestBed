package org.usfirst.frc1318.minimike.shared;

public class MMTurretData {
	static double turnSpeed = 0;
	
	public static void setTurnSpeed(double speed)
	{
		turnSpeed = speed;
	}
	
	public static double getTurnSpeed()
	{
		return turnSpeed;
	}
	
}
