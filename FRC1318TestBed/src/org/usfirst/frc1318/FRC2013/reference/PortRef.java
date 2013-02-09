package org.usfirst.frc1318.FRC2013.reference;

import edu.wpi.first.wpilibj.SensorBase;

public interface PortRef {

	int GAMEPAD = 0;
	int JOYSTICK_L = 0;
	int JOYSTICK_R = 1;
	int SIDECAR_SLOT = 2;
	int SHOOTER_UP_SOLENOID = 0;//TODO
	int SHOOTER_DOWN_SOLENOID = 0;//TODO
	
	int LIFTER_EXTENDER_SOLENOID_PORT = 1;
	int LIFTER_RETRACTOR_SOLENOID_PORT = 2;
	
	int SIDECAR_PORT = SensorBase.getDefaultDigitalModule();
	int SOLENOID_MODULE_PORT = SensorBase.getDefaultSolenoidModule();
	
	int LIFTER_LIMIT_SWITCH_PORT = 0;//TODO
}
