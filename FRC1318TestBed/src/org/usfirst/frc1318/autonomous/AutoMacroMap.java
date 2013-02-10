package org.usfirst.frc1318.autonomous;

import org.usfirst.frc1318.autonomous.macros.*;

public class AutoMacroMap
{
	//reads from the button table.
	//will use an ElseIf to see if buttons are pressed, certain ones taking priority
	
	public static void update()
	{//ALL BUTTONS MUST BE TOGGLE!
		if(true)//anybutton.ispressed()
		{
			if(!true)//AutoRunner.hasActiveTask()
			{
				if(true)//button adfasdf.isDown() or whatever
				{
					//AutoRunner.addTask(new someMacro())
				}
				else if(true)
				{
					//more button stuff...
				}
			}
			else
			{
				//AutoRunnner.cancelTask();
			}
		}
	}
}
