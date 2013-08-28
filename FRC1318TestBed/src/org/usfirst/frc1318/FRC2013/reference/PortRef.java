package org.usfirst.frc1318.FRC2013.reference;
import edu.wpi.first.wpilibj.SensorBase;

public interface PortRef {

	int GAMEPAD = 1;
	
	int JOYSTICK_L = 1;
	int JOYSTICK_R = 2; 
	
	int SIDECAR_SLOT = SensorBase.getDefaultDigitalModule();
	int DIGITAL_IO = SensorBase.getDefaultSolenoidModule();
	
	int SHOOTER_UP_SOLENOID = 2;
	int SHOOTER_DOWN_SOLENOID = 5;
	int SHOOTER_ENCODER_A = 6;//TODO
	int SHOOTER_ENCODER_B = 7;//TODO
	int SHOOTER_MOTOR = 4;

	int SHOOTER_FIRE_RETRACT = 3;
	int SHOOTER_FIRE_EXTEND = 4;
	
	int LIFTER_EXTENDER_SOLENOID_PORT = 6;
	int LIFTER_RETRACTOR_SOLENOID_PORT = 1;

	int ANALOG_MODULE = SensorBase.getDefaultAnalogModule();
	int TACH_PORT = 2;
	
	int SIDECAR_PORT = SensorBase.getDefaultDigitalModule();
	int SOLENOID_MODULE_PORT = SensorBase.getDefaultSolenoidModule();//3
	
	int LIFTER_LIMIT_SWITCH_PORT = 0;//TODO
	
	
	int ENCODER_L_A = 2; 
	int ENCODER_L_B = 3;

	int ENCODER_R_A = 4;
	int ENCODER_R_B = 5;
	
	int TALON_R = 2;
	int TALON_L = 1;

	int AIR_PRESSURE_SWITCH_CHANNEL = 10;
	int AIR_RELAY_CHANNEL = 1;

	int SERVO = 0; //TODO

}
