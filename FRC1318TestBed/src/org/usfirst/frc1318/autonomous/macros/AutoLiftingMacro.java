package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoLiftingMacro implements AutoTask{
	
	final int ADJUST_LIFTER_AND_SHOOTER = 0;
	final int DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED = 1;
	final int ACTUATE_LIFTER = 2;
	final int AUTO_LIFTING_MACRO_DEFAULT = DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED;
	final int DONE = 9001;
	
	private int currentState = ADJUST_LIFTER_AND_SHOOTER;
	
	private final double SLOW_DRIVE_SPEED = .2;
	private final double STOP = 0;

	private boolean hasFinished = false;
	private boolean hasInitalized = false;
	
	public void init() {
		hasInitalized = true;
		System.out.println("AutoLifting init");
	}

	public void run() {
		System.out.println("AutoLifting currentState: " + currentState);
		switch(currentState) {
		case ADJUST_LIFTER_AND_SHOOTER:
			adjustLifterAndShooter();
		case DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED:
			driveSlowlyTillSwitchTriggered();
			break;
		case ACTUATE_LIFTER:
			actuateLifter();
			break;
		default:
			hasFinished = true;
			break;
		}
	}

	public void cancel() {
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
	}

	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInitalized;
	}
	
	private void adjustLifterAndShooter() {
		ReferenceData.getInstance().getUserInputData().setLiftDown(true);
		ReferenceData.getInstance().getUserInputData().setShooterDown(true);
		
		currentState = DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED;
	}

	private void driveSlowlyTillSwitchTriggered() {
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(SLOW_DRIVE_SPEED);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(SLOW_DRIVE_SPEED);
		if (ReferenceData.getInstance().getLifterLimitSwitchData().getIsSwitched()) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
			
			currentState = ACTUATE_LIFTER;
		}
	}
	
	private void actuateLifter() {
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		
		currentState = DONE;
	}
}
