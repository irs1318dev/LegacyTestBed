package org.usfirst.frc1318.shared.minimike;

public class MMTurretData {
	static double turnSpeed = 0;
	public static final int TURN_RIGHT = 1;
	public static final int TURN_LEFT = -1;
	
	public static void setTurnSpeed(double speed)
	{
		turnSpeed = speed;
	}
	
	public static double getTurnSpeed()
	{
		return turnSpeed;
	}
	
}
