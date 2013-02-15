package org.usfirst.frc1318.FRC2013.readers;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;

public class ShooterEncoderReader {
	EncoderAngularVelocity encoder;
	ShooterData shooterData;
	
	public void robotInit()
	{
		//TODO Encoder class might need a constant to scale the output by
		encoder = new EncoderAngularVelocity(PortRef.SHOOTER_ENCODER_A,
												PortRef.SHOOTER_ENCODER_B);
		encoder.start();
		
		shooterData = ReferenceData.getInstance().getShooterData();
	}
	
	public void teleopPeriodic()
	{
		shooterData.setEncoderAngularVelocity(encoder.getRate());
	}
	
}
