package org.usfirst.frc1318.FRC2013.shared;

import org.usfirst.frc1318.generic.utils.SettingsLookup;

 public class ShooterData {
	
	
	private double motorSetPoint = 0;
	private double encoderAngularVelocity = 0;
	private double motorSpeed = 0;
	
	private boolean hasFrisbees = false;
	
	private boolean shouldFire = false;
	
	private SettingsLookup speedSettings;
	
	 public void setEncoderAngularVelocity(double velocity)
	{
		encoderAngularVelocity = velocity;
	}
	
	 public double getEncoderAngularVelocity()
	{
		return encoderAngularVelocity;
	}
	
	 public boolean getHasFrisbees()
	{
		return hasFrisbees;
	}
	
	 public void setHasFrisbees(boolean frisbees)
	{
		hasFrisbees = frisbees;
	}
	
	 public void setMotorSetPoint(double setPoint)
	{
		motorSetPoint = setPoint;
	}
	
	 public double getMotorSetPoint()
	{
		return motorSetPoint;
	}

	 public void setMotorSpeed(double speed) {
		motorSpeed = speed;
	}

	 public double getMotorSpeed() {
		return motorSpeed;
	}
	
	 public void setShouldFire(boolean shouldI)
	{
		shouldFire = shouldI;
	}
	
	 public boolean getShouldFire()
	{
		return shouldFire;
	}

	public SettingsLookup getSpeedSettings() {
		if(speedSettings == null)
			speedSettings = new SettingsLookup();
		return speedSettings;
	}
	
	public void setSpeedSettings(SettingsLookup value)
	{
		speedSettings = value;
	}

}