package org.usfirst.frc1318.FRC2013.shared;

public class ShooterData {
	
	private static boolean shooterAngle = false;
	
	private static double motorSetPoint = 0;
	private static double encoderAngularVelocity = 0;
	private static double motorSpeed = 0;
	
	private static boolean hasFrisbees = false;
	
	private static boolean shouldFire = false;
	
	public interface constants{
		public static final boolean SHOOTER_UP = true;
		public static final boolean SHOOTER_DOWN = false;
	}
	
	public void setShooterAngle(boolean upOrDown)
	{
		shooterAngle = upOrDown;
	}
	
	public static boolean getShooterAngle()
	{
		return shooterAngle;
	}
	
	public static void setEncoderAngularVelocity(double velocity)
	{
		encoderAngularVelocity = velocity;
	}
	
	public static double getEncoderAngularVelocity()
	{
		return encoderAngularVelocity;
	}
	
	public static boolean getHasFrisbees()
	{
		return hasFrisbees;
	}
	
	public static void setHasFrisbees(boolean frisbees)
	{
		hasFrisbees = frisbees;
	}
	
	public static void setMotorSetPoint(double setPoint)
	{
		motorSetPoint = setPoint;
	}
	
	public static double getMotorSetPoint()
	{
		return motorSetPoint;
	}

	public static void setMotorSpeed(double speed) {
		motorSpeed = speed;
	}

	public static double getMotorSpeed() {
		return motorSpeed;
	}
	
	public static void setShouldFire(boolean shouldI)
	{
		shouldFire = shouldI;
	}
	
	public static boolean getShouldFire()
	{
		return shouldFire;
	}

}
