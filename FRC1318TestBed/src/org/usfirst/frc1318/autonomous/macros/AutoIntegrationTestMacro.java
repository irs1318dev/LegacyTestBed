package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.autonomous.AutoTask;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

public class AutoIntegrationTestMacro implements AutoTask
{
	boolean hasInit = false;
	boolean hasFinished = false;
	long localTime;
	
	public void init() 
	{
		localTime = System.currentTimeMillis();
		hasInit = true;
	}

	public void run() 
	{
		if(System.currentTimeMillis() > localTime + 10000)
		{
			ReferenceData.getInstance().getJoystickData().setJoystickLY(1);
		}
		else
		{
			hasFinished = true;;
		}
	}

	public void cancel() 
	{
		ReferenceData.getInstance().getJoystickData().setJoystickLY(0);
	}

	public boolean hasFinished() 
	{
		return hasFinished;
	}
	
	public boolean hasInitalized() 
	{
		return hasInit;
	}

}
