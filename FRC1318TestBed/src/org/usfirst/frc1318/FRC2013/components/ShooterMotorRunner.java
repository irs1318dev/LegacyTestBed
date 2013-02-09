package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import edu.wpi.first.wpilibj.Talon;

public class ShooterMotorRunner extends RobotComponentBase{
	private Talon motor;
	
	public void RobotInit() {
		
		motor = new Talon(PortRef.SIDECAR_SLOT, PortRef.SHOOTER_MOTOR);
	}
	
	public void teleopPeriodic() {
		ReferenceData.getInstance().getShooterData().setMotorSpeed(ReferenceData.getInstance().getJoystickData().getJoystickLY());
		motor.set(ReferenceData.getInstance().getShooterData().getMotorSpeed());
	}

	

}
