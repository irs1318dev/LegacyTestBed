package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class ShooterMotorRunner extends RobotComponentBase{
	private Talon motor;
	
	public void RobotInit() {
		
		motor = new Talon(PortRef.SIDECAR_SLOT, PortRef.SHOOTER_MOTOR);
	}
	
	public void teleopPeriodic() {
		motor.set(ShooterData.getMotorSpeed());
	}

	

}
