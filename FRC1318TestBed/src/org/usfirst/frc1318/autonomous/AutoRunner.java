package org.usfirst.frc1318.autonomous;

import java.util.Vector;

import org.usfirst.frc1318.autonomous.macros.AutoDriveShootMacro;
import org.usfirst.frc1318.components.RobotComponentBase;

public class AutoRunner extends RobotComponentBase
{
	public AutoTask task;
	public Vector completedTasks;
	public AutoMacroMap macroMap = new AutoMacroMap(this);
	
	public void robotInit() 
	{//sets up the variables. set the initial task here, for say autonomous period.
		task = new AutoDriveShootMacro(); // the first task that will be run.
		completedTasks = new Vector();
	}
	
	public void teleopPeriodic()
	{//runs through checking if we need to do anything.
		macroMap.periodic();
		if(task != null){// runs our active task if we have one (other than dormant)
			if(!task.hasInitalized()){
				task.init();
			}else if(!task.hasFinished()){
				task.run();
			}else{
				completedTasks.addElement(task);
				//TODO: add to data structure for network table.
				task = null;
			}
		}
	}
	
	public void setTask(AutoTask task)
	{//set the task to another task, presumably one that is new.
		this.task = task;
	}
	
	public boolean hasActiveTask()
	{//do we have an active task?
		return task != null;
	}
	
	public void cancelTask()
	{// makes all autonomous tasks do nothing
		if(task != null)
			task.cancel();
		task = null;
	}
	
	public AutoTask getTask(){
		return task;
	}
}
