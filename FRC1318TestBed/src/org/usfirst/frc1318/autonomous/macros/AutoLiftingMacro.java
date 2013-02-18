package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.reference.StateRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoLiftingMacro implements AutoTask{
	
	private int currentState = StateRef.ADJUST_LIFTER_AND_SHOOTER;
	
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
		case StateRef.ADJUST_LIFTER_AND_SHOOTER:
			adjustLifterAndShooter();
		case StateRef.DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED:
			driveSlowlyTillSwitchTriggered();
			break;
		case StateRef.ACTUATE_LIFTER:
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
		
		currentState = StateRef.DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED;
	}

	private void driveSlowlyTillSwitchTriggered() {
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(SLOW_DRIVE_SPEED);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(SLOW_DRIVE_SPEED);
		if (ReferenceData.getInstance().getLifterLimitSwitchData().getIsSwitched()) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
			
			currentState = StateRef.ACTUATE_LIFTER;
		}
	}
	
	private void actuateLifter() {
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		
		currentState = StateRef.DONE;
	}
}
