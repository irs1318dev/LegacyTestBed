package org.usfirst.frc1318.FRC2013.reference;

public interface StateRef {
	//States for AutoLiftingMacro
	int ADJUST_LIFTER_AND_SHOOTER = 0;
	int DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED = 1;
	int ACTUATE_LIFTER = 2;
	int AUTO_LIFTING_MACRO_DEFAULT = DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED;
	
	//States for AutoDriveShootMacro
	int INITIALIZE = 0;
	int PREPRARE_TO_DRIVE_UNDER_PYRAMID = 1;
	int DRIVE_TO_LAUNCH_POSITION = 2;
	int PREPARE_TO_SHOOT = 3;
	int FIRE = 4;
	int PREPARE_TO_DRIVE = 5;
	int BACK_UP = 6;
	int ROTATE = 7;
	int AUTO_DRIVE_SHOOT_MACRO_DEFAULT = INITIALIZE;
	
	int DONE = 9001;
}
