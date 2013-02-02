package org.usfirst.frc1318.minimike.shared.constants;

import org.usfirst.frc1318.generic.reference.PS2Controller;

public interface MMButtonRef{

	public static final int PRESS_AND_HOLD = 0;
	public static final int TOGGLE = 1;
	
	public static final int ROTATE_LEFT	= PS2Controller.PS2ButtonMap.L1;
	public static final int ROTATE_RIGHT = PS2Controller.PS2ButtonMap.R1;
	public static final int AUTONOMOUS_TOGGLE = 4;
	
	public static final int NUM_BUTTONS = 3;
	
}
 