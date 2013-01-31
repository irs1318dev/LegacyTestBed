package org.usfirst.frc1318.minimike.networktable;

import org.usfirst.frc1318.components.RobotComponentBase;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;

//Knue
public class NetworkTableTest extends RobotComponentBase
{
	int time;
	int val;
	
	public void robotInit()
	{
		
	}
	
	public void teleopPeriodic()
	{
		if(time++ % 50 == 0)
		{
			synchronized(NetworkTable.getTable("test"))
			{
				NetworkTable.getTable("test").putInt("+", val++);
				System.out.println("the value of \"plus\" is: " + val);
				try
				{
					System.out.println("the value of \"minus\" is: " + NetworkTable.getTable("test").getInt("-"));
				}
				catch (NetworkTableKeyNotDefined e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void disabledInit()
	{
		val = 0;
	}
}
