package org.usfirst.frc1318.FRC2013.reference;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.SensorBase;

public interface PortRef {

	int GAMEPAD = 0;
	int JOYSTICK_L = 0;
	int JOYSTICK_R = 1;
	int SIDECAR_SLOT = SensorBase.getDefaultDigitalModule();//2
	int SHOOTER_UP_SOLENOID = 0;//TODO
	int SHOOTER_DOWN_SOLENOID = 0;//TODO
	int SHOOTER_ENCODER_A = 0;//TODO
	int SHOOTER_ENCODER_B = 0;//TODO
	int SHOOTER_MOTOR = 0;//TODO
	int SHOOTER_FIRE_RETRACT = 0;//TODO
	int SHOOTER_FIRE_EXTEND = 0;//TODO
}
