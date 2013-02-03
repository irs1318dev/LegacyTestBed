package org.usfirst.frc1318.autonomous;

public class AutoInitalizer {
	private boolean finished = false;
	
	
	public void run()
	{
		finished = true;
	}
	public boolean isFinished()
	{
		return finished;
	}
	public void init()
	{
		finished = false;
	}
}
