package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.reference.StateRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoLiftingMacro implements AutoTask{
	
	private int currentState = StateRef.AUTO_LIFTING_MACRO_DEFAULT_STATE;
	
	private final double SLOW_DRIVE_SPEED = .2;
	private final double STOP = 0;
	private final boolean LIFT = true;

	private boolean hasFinished = false;
	private boolean hasInitalized = false;
	
	public void init() {
		
		hasInitalized = true;
	}

	public void run() {
		switch(currentState) {
		case StateRef.DRIVE_SLOWLY_TILL_SWITCH_TRIGGERED_STATE:
			driveSlowlyTillSwitchTriggered();
			break;
		case StateRef.ACTUATE_LIFTER_STATE:
			actuateLifter();
			break;
		default:
			break;
		}
		hasFinished = true;
	}

	public void cancel() {
		
	}

	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInitalized;
	}

	private void driveSlowlyTillSwitchTriggered() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(SLOW_DRIVE_SPEED);
		ReferenceData.getInstance().getJoystickData().setJoystickRY(SLOW_DRIVE_SPEED);
		if (ReferenceData.getInstance().getLifterLimitSwitchData().getIsSwitched()) {
			ReferenceData.getInstance().getJoystickData().setJoystickLY(STOP);
			ReferenceData.getInstance().getJoystickData().setJoystickRY(STOP);
			
			currentState = StateRef.ACTUATE_LIFTER_STATE;
		}
	}
	
	private void actuateLifter() {
		ReferenceData.getInstance().getJoystickData().setLiftUp(LIFT);
	}
}
