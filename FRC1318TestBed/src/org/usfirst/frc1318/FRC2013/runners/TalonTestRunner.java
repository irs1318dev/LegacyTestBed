package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class TalonTestRunner extends RobotComponentBase {
	private Talon rightTalon;
	private Talon leftTalon;
	
	public void robotInit() {
		rightTalon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_R);
		leftTalon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON_L);
	}
	
	public void teleopPeriodic() {
		rightTalon.set(1);
		leftTalon.set(1);
	}
}
