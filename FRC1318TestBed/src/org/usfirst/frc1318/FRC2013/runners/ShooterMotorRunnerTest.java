package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import edu.wpi.first.wpilibj.Jaguar;

public class ShooterMotorRunnerTest extends RobotComponentBase{
	private Jaguar motor;
	
	public void robotInit() {
		motor = new Jaguar(PortRef.SIDECAR_SLOT, PortRef.SHOOTER_MOTOR);
	}
	
	public void teleopPeriodic() {
		//ReferenceData.getInstance().getShooterData().setMotorSpeed(ReferenceData.getInstance().getJoystickData().getJoystickLY());
		motor.set(0.5);
		//System.out.println("The Motor Speed has been set to " + (ReferenceData.getInstance().getShooterData().getMotorSpeed()));
	}
}
