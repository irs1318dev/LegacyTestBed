package org.usfirst.frc1318.FRC2013.reference;
//TODO: Put our constants in our classes
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
	
	//States for AutTranslateLeftMacro
	int GO_FORWARD_1 = 0;
	int TURN_RIGHT = 1;
	int GO_FORWARD_2 = 2;
	int TURN_LEFT = 3;
	int GO_BACKWARD = 4;
	int DEFAULT = 5;
	
	
	int DONE = 9001;
	
}
