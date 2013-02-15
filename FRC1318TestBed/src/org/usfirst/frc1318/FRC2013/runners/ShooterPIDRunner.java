package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.PID;

public class ShooterPIDRunner extends RobotComponentBase {
	PID shooterPID;
	
	
	public void robotInit()
	{	
		shooterPID = new PID(1,1,1);//TODO adjust values
		shooterPID.setKFade(.75);
	}
	
	public void teleopPeriodic()
	{
		shooterPID.setSetpoint(ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		shooterPID.input(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity());
		ReferenceData.getInstance().getShooterData().setMotorSpeed(shooterPID.getOutput());
	}
	
}
