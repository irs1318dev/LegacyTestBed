package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoTranslateMacro implements AutoTask
{
	private boolean hasInit = false;
	private boolean hasFinished = false;
	
	public int state;
	public int ticksForward1;
	
	
	public void init() {
		// create things
		state = 0;
		hasInit = true;
	}

	public void run() 
	{
		switch(state)
		{
		case 0:
			goForward1();
			break;
		case 1:
			turnRight();
			break;
		case 2:
			goForward2();
			break;
		case 3:
			turnLeft();
			break;
		case 4:
			goBackward();
			break;
		default:
			hasFinished = true;
			break;
		}
		
	}

	public void cancel() {
		// this is were you set any variables you were messing with
		// to their default value, or the value before the Macro started.
	}

	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInit;
	}
	
	public void goForward1()
	{// this is the first time we are moving forward.
		if(ticksForward1 < 1080) // three wheel rotations.
		{
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(1);
		}
		else
		{
			state = 1;
		}
	}
	
}