package org.usfirst.frc1318.autonomous;

public class Interval 
{
	protected long start = 0;
	protected long end = 0;
	
	public Interval() { }
	public Interval(long start)
	{
		this.start = start;
	}
	
	public void start(long start)
	{
		this.start = start;
	}
	public void end(long end)
	{
		this.end = end;
	}
	public long getDifference()
	{
		if(start < end)
			return end - start;
		else
			throw new IllegalStateException("Start is same as or greater than end. Difference is "+ (end -start));
	}
}
