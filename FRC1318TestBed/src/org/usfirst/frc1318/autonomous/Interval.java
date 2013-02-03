package org.usfirst.frc1318.autonomous;

public class Interval 
{
	protected double start = 0;
	protected double end = 0;
	
	public Interval() { }
	public Interval(double start)
	{
		this.start = start;
	}
	
	public void start(double start)
	{
		this.start = start;
	}
	public void end(double end)
	{
		this.end = end;
	}
	public double getDifference()
	{
		if(start < end)
			return end - start;
		else
			return (end - start) * -1;
	}
}
