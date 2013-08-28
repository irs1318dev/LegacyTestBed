package org.usfirst.frc1318.legoarmbot.shared.constants;

import org.usfirst.frc1318.generic.reference.GamePad.ButtonVals;


public interface GamePadRef {
	int LIFT_DOWN= ButtonVals.Y;
	int LIFT_UP = ButtonVals.B;
	
	int SHOOTER_UP = ButtonVals.A;//square
	int CHANGE_JOYSTICK_MODE = ButtonVals.X;//x
	
	int SHOOTER_SPEED_UP = ButtonVals.LB;//L2
	int SHOOTER_SPEED_DOWN = ButtonVals.LT;//L1
	
	int SHOOTER_FIRE = ButtonVals.RB;//R1
	
	
}
