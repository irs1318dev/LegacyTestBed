package org.usfirst.frc1318.FRC2013.reference;
import edu.wpi.first.wpilibj.SensorBase;

public interface PortRef {

	int GAMEPAD = 1;
	
	int JOYSTICK_L = 0;
	int JOYSTICK_R = 1;
	
	int SIDECAR_SLOT = SensorBase.getDefaultDigitalModule();
	
	int SHOOTER_UP_SOLENOID = 2;
	int SHOOTER_DOWN_SOLENOID = 5;
	int SHOOTER_ENCODER_A = 0;//TODO
	int SHOOTER_ENCODER_B = 0;//TODO
	int SHOOTER_MOTOR = 4;
	int SHOOTER_FIRE_RETRACT = 3;
	int SHOOTER_FIRE_EXTEND = 6;
	
	int LIFTER_EXTENDER_SOLENOID_PORT = 4;
	int LIFTER_RETRACTOR_SOLENOID_PORT = 1;
	
	int SIDECAR_PORT = SensorBase.getDefaultDigitalModule();
	int SOLENOID_MODULE_PORT = SensorBase.getDefaultSolenoidModule();//3
	
	int LIFTER_LIMIT_SWITCH_PORT = 0;//TODO
	
	
	int ENCODER_R = 3;
	int ENCODER_L = 4;
	
	int TALON_R = 2;
	int TALON_L = 1;

	int AIR_PRESSURE_SWITCH_CHANNEL = 0;//TODO
	int AIR_RELAY_CHANNEL = 0;//TODO

}
