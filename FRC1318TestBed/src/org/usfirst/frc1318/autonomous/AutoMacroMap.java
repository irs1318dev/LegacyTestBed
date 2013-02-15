package org.usfirst.frc1318.autonomous;

import org.usfirst.frc1318.autonomous.macros.*;
import org.usfirst.frc1318.generic.shared.GamePadData;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;


public class AutoMacroMap
{
	  
	public boolean FAKE_BUTTON_1_isDown = true;
	public boolean FAKE_BUTTON_2_isDown = false;
	public boolean runTest = false;
	private AutoRunner autoRunner;
	
	public AutoMacroMap(AutoRunner autoRunner)
	{
		this.autoRunner = autoRunner;
	}
	
	//reads from the button table.
	//will use an ElseIf to see if buttons are pressed, certain ones taking priority
	
	public void update()
	{
		//if(true)//anybutton.ispressed()
		//{
		if(!autoRunner.hasActiveTask() && !runTest)
		{
			if(FAKE_BUTTON_1_isDown)
			{
				autoRunner.setTask(new AutoLiftingMacro());
				runTest = true;
			}
			else if(FAKE_BUTTON_2_isDown)
			{
				autoRunner.setTask(new AutoLiftingMacro());
			}
		}
		else
		{
			autoRunner.cancelTask();
		}
		//}
	}
}
