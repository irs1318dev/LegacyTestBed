package org.usfirst.frc1318.FRC2013.reference;

public interface StateRef {
	//States for AutoLiftingMacro
	int ADJUST_LIFTER_AND_SHOOTER = 0;
	int DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED_STATE = 1;
	int ACTUATE_LIFTER_STATE = 2;
	int AUTO_LIFTING_MACRO_DEFAULT_STATE = DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED_STATE;
	
	int DONE_STATE = 9001;
}
