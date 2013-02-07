package org.usfirst.frc1318.FRC2013.shared;

public class ShooterData {
	public static int encoderValue = 0;
	public static boolean shooterAngle = false;
	
	public interface constants{
		
		public static final boolean SOLENOID_UP = true;
		public static final boolean SOLENOID_DOWN = false;
	
	}
	
	public void setShooterAngle(boolean upOrDown)
	{
		shooterAngle = upOrDown;
	}
}
