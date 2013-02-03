package org.usfirst.frc1318.autonomous;
import java.util.Vector;

public class AutoTaskListSequence implements AutoTask{
	private Vector tasklist;
	protected int current;
	
	public void init()
	{
		tasklist = new Vector();
		for(int i = 0; i < tasklist.size(); i++)
			((AutoTask)(tasklist.elementAt(i))).init();
	}
	public void run() 
	{
		if(!hasFinished())
		{
			AutoTask currentTask = (AutoTask)tasklist.elementAt(current);
			currentTask.run();
			if(currentTask.hasFinished())
				current++;
		}
	}
	public boolean hasFinished() 
	{
		return current > tasklist.size() - 1;
	}
	public void add(AutoTask newTask) 
	{
		tasklist.addElement(newTask);
	}
	
	protected void addElements(){ }
}
