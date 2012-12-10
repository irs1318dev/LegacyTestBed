package org.usfirst.frc1318.shared.constants;

import org.usfirst.frc1318.reference.GamePad;
import org.usfirst.frc1318.reference.GamePadReader;
import org.usfirst.frc1318.reference.PS2Controller.PS2ButtonMap;

public interface ButtonRef 
{
	int TOGGLE = 1;
	int PRESS_AND_HOLD = 0;
	
	int CONVEYOR_LOWER_OVERRIDE_JS = PortRef.PILOT_LEFT_JS;
	int CONVEYOR_UPPER_OVERRIDE_JS = PortRef.PILOT_RIGHT_JS;
	int MECANUM_V_JS = PortRef.PILOT_PAD;
	
	int GYRO_JS = PortRef.PILOT_LEFT_JS;
	int GYRO_ON_OFF = 6;
	int UNUSED = 15;
	int GYRO_OVERRIDE_0 = UNUSED;
	int GYRO_OVERRIDE_90 = UNUSED;
	int GYRO_OVERRIDE_180 = UNUSED;
	int GYRO_OVERRIDE_270 = UNUSED;
	int GYRO_RESET_0 = 2;
	int GYRO_RESET_90 = 5;
	int GYRO_RESET_180 = 3;
	int GYRO_RESET_270 = 4;
	int GYRO_OVERRIDE = 10;
	int GYRO_OVERRIDE_BUTTON = 11;
	int DISABLE_GYRO = 12;
	
	int TURRET_JS = PortRef.PILOT_RIGHT_JS;
	int TURRET_AND_WHEELS_READY_OVERRIDE = 1;
	int TOP_LIMIT_SWITCH_OVERRIDE = 2;
	int GYRO_OVERRIDE_TOGGLE = 3;
	int TIPPER_DEPLOY_BUTTON = 4;
	int TIPPER_DIRECTION_SWITCH = 5;
	int TIPPER_THROTTLE = 6;
	int RECORD_STATE_CALIBRATE = 7;
	int GLOBAL_STOP = 8;
	int LAUNCHER_THROTTLE = 9;
	int TURRET_ANGLE = 10;
	int VERTICAL_BELT_SWITCH = 11;
	int BELT1_SWITCH = 12;
	int BELT2_SWITCH = 13;
	
	int NUMBER_OF_BUTTONS = 27;
	int BUTTONS_PER_JOYSTICK = 15;
	int SHOOTER_JS = PortRef.COPILOT_JS;
	int TIPPER_JS = PortRef.COPILOT_JS;
	int TIPPER_PUT_DOWN = 5;
	int TIPPER_PUT_UP = 4;
	int TIPPER_JOYSTICK = PortRef.PILOT_RIGHT_JS;
	
	
	int OVERRIDE_PAD = PortRef.COPILOT_PAD;
	int SHOOTER_OVERRIDE_ENABLE = GamePad.ButtonVals._8;
	int TURRET_OVERRIDE_ENABLE = GamePad.ButtonVals._7;
	int MISSED_SHOT = GamePad.ButtonVals._5;
	int MADE_SHOT = GamePad.ButtonVals._8;
	int RESET_ALL_TRIM = GamePad.ButtonVals._10;
	int OVERRIDE_RESET = GamePad.ButtonVals._4;
	int TRIM_PAD = PortRef.COPILOT_PAD;
	int TRIM_RESET_SHOOTER = GamePad.ButtonVals._1;
	int TRIM_RESET_TURRET = GamePad.ButtonVals._3;
	int SHOOTER_OVERRIDE_JS = PortRef.COPILOT_PAD;
	int FIRE = GamePad.ButtonVals._2;

}
