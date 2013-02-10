package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.reference.StateRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoLiftingMacro implements AutoTask{
	
	private int currentState = StateRef.AUTO_LIFTING_MACRO_DEFAULT_STATE;

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
		if (ReferenceData.getInstance().getLifterLimitSwitchData().getIsSwitched()) {
			currentState = StateRef.ACTUATE_LIFTER_STATE;
		}
	}
	
	private void actuateLifter() {
		
	}
}
