package org.usfirst.frc1318.autonomous; 

import org.usfirst.frc1318.autonomous.macros.*;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;


public class AutoMacroMap
{
	private AutoRunner autoRunner;
	
	public AutoMacroMap(AutoRunner autoRunner)
	{
		this.autoRunner = autoRunner;
	}
	
	//reads from the button table.
	//will use an ElseIf to see if buttons are pressed, 
	//certain ones taking priority
	
	public void periodic() // change to other update
	{
		if(ReferenceData.getInstance().getUserInputData().getAnyUI())//anybutton.ispressed()
		{
			if(autoRunner.hasActiveTask())
			{
				autoRunner.cancelTask();
			}
			if(!autoRunner.hasActiveTask())
			{
				//If you add a macro, create a button in UserInputData and a button reference in the GamePad1Ref and Joystick1Ref and Joystick2Ref
				if(ReferenceData.getInstance().getUserInputData().getAutoLift())
				{
					autoRunner.setTask(new AutoLiftingMacro());
				}
				else if(ReferenceData.getInstance().getUserInputData().getAutoTranslateLeft())
				{
					autoRunner.setTask(new AutoTranslateRightMacro());
				}
				else if(ReferenceData.getInstance().getUserInputData().getAutoTranslateRight())
				{
					autoRunner.setTask(new AutoTranslateRightMacro());
				}
				else if(ReferenceData.getInstance().getUserInputData().getAutoDriveShoot())
				{
					autoRunner.setTask(new AutoDriveShootMacro());
				}
				else if(ReferenceData.getInstance().getUserInputData().getAutoSpinToAim())
				{
					autoRunner.setTask(new AutoSpinToAimMacro());
				}
				else if(ReferenceData.getInstance().getUserInputData().getAutoSpinToLoad())
				{
					autoRunner.setTask(new AutoSpinToLoadMacro());
				}
			}
		}
	}
}
