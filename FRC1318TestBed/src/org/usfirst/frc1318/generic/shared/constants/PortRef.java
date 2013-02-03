package org.usfirst.frc1318.generic.shared.constants;

import edu.wpi.first.wpilibj.SensorBase;

public interface PortRef {
	static final int GAMEPAD = 1;
	
	static final int LIFTER_SOLENOID_PORT_1 = 1;
	static final int LIFTER_SOLENOID_PORT_2 = 2;
	
	static final int SIDECAR_PORT = SensorBase.getDefaultDigitalModule();
	static final int SOLENOID_MODULE_PORT = SensorBase.getDefaultSolenoidModule();
}
