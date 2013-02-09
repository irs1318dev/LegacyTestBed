package org.usfirst.frc1318.generic.shared.constants;

import edu.wpi.first.wpilibj.SensorBase;

public interface PortRef {
	static final int GAMEPAD = 1;
	
	static final int LIFTER_EXTENDER_SOLENOID_PORT = 1;
	static final int LIFTER_RETRACTOR_SOLENOID_PORT = 2;
	
	static final int SIDECAR_PORT = SensorBase.getDefaultDigitalModule();
	static final int SOLENOID_MODULE_PORT = SensorBase.getDefaultSolenoidModule();
}
