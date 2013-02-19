package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoTranslateRightMacro implements AutoTask{
	private boolean hasInit = false;
	private boolean hasFinished = false;
	
	private int state;
	private int ticksStartLeft;
	private int ticksStartRight;
	
	final int GO_FORWARD_1 = 0;
	final int TURN_RIGHT = 1;
	final int GO_FORWARD_2 = 2;
	final int TURN_LEFT = 3;
	final int GO_BACKWARD = 4;
	final int DEFAULT = 5;
	
	//TODO figure out numbers
	private final int TICKS_FORWARD1 = 1080;
	private final int TICKS_TURN_RIGHT = 120;
	private final int TICKS_FORWARD2 = 200;
	private final int TICKS_TURN_LEFT = 120;
	private final int TICKS_BACKWARD = 1260;
	
	
	public void init() {
		// create things
		state = GO_FORWARD_1;
		ticksStartLeft = (int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
		ticksStartRight = (int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
		System.out.println("AutoTranslateRight init");
		hasInit = true;
	}

	public void run() {
		System.out.println("AutoTranslateRight currentState: " + state);
		switch(state){
		case GO_FORWARD_1:
			goForward1();
			break;
		case TURN_RIGHT:
			turnRight();
			break;
		case GO_FORWARD_2:
			goForward2();
			break;
		case TURN_LEFT:
			turnLeft();
			break;
		case GO_BACKWARD:
			goBackward();
			break;
		default:
			hasFinished = true;
			break;
		}
		
	}


	public void cancel() {
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
		ReferenceData.getInstance().getUserInputData().setJoystickX(0);
		ReferenceData.getInstance().getUserInputData().setJoystickY(0);
	}

	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInit;
	}
	
	public void goForward1(){// this is the first time we are moving forward.
		if(		(int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() < ticksStartLeft + TICKS_FORWARD1 &&
				(int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() < ticksStartRight + TICKS_FORWARD1){ 
							// three wheel rotations.{
			//TODO: Find a better way to account for either set of controls
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(1);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(1);
		}else{
			ticksStartLeft = (int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
			ticksStartRight = (int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
			//state = StateRef.TURN_RIGHT;
		}
	}
	
	private void turnRight() {
		if(		(int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() < ticksStartLeft + TICKS_TURN_RIGHT &&
				(int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() > ticksStartRight - TICKS_TURN_RIGHT){
			//TODO check values
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(.5);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(-.5);
			ReferenceData.getInstance().getUserInputData().setJoystickX(.5);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		}else{
			ticksStartLeft = (int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
			ticksStartRight = (int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
			state = GO_FORWARD_2;
		}
	}
	
	private void goForward2() {
		if(		(int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() < ticksStartLeft + TICKS_FORWARD2 &&
				(int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() < ticksStartRight + TICKS_FORWARD2){ 
							// three wheel rotations
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(1);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(1);
		}else{
			ticksStartLeft = (int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
			ticksStartRight = (int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
			state = TURN_LEFT;
		}
	}
	
	private void turnLeft() {
		if(		(int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() > ticksStartLeft - TICKS_TURN_LEFT &&
				(int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() < ticksStartRight + TICKS_TURN_LEFT){
			//TODO check values
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-.5);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(.5);
			ReferenceData.getInstance().getUserInputData().setJoystickX(-.5);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		}else{
			ticksStartLeft = (int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
			ticksStartRight = (int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
			state = GO_BACKWARD;
		}
	}
	
	private void goBackward() {
		if(		(int)ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() > ticksStartLeft - TICKS_BACKWARD &&
				(int)ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() > ticksStartRight - TICKS_BACKWARD){
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(-1);
		}else{
			state = DEFAULT;
		}
	}
	
}