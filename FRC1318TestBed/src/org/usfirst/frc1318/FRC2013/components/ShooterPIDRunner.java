package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.PID;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;

public class ShooterPIDRunner extends RobotComponentBase {
	PID shooterPID;
	EncoderAngularVelocity encoder;
	
	public void robotInit()
	{
		//Encoder class might need a constant to scale the output by
		encoder = new EncoderAngularVelocity(PortRef.SHOOTER_ENCODER_A,
												PortRef.SHOOTER_ENCODER_B);
		encoder.start();
		
		shooterPID = new PID(1,1,1);//TODO adjust values
		shooterPID.setKFade(.75);
	}
	
	public void teleopPeriodic()
	{
		shooterPID.setSetpoint(ShooterData.getMotorSetPoint());
		shooterPID.input(encoder.getRate());
		ShooterData.setMotorSpeed(shooterPID.getOutput());
	}
	
}
