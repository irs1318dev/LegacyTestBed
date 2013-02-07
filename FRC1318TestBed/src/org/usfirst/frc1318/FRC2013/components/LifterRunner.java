package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.shared.constants.PortRef;

import edu.wpi.first.wpilibj.Solenoid;

public class LifterRunner extends RobotComponentBase{
	private Solenoid lifterSolenoid1;
	private Solenoid lifterSolenoid2;
	
	public void robotInit() {
		lifterSolenoid1 = new Solenoid(PortRef.SOLENOID_MODULE_PORT, PortRef.LIFTER_SOLENOID_PORT_1);
		lifterSolenoid2 = new Solenoid(PortRef.SOLENOID_MODULE_PORT, PortRef.LIFTER_SOLENOID_PORT_2);
	}
}
