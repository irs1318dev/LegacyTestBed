package org.usfirst.frc1318.minimike.networktable;

import org.usfirst.frc1318.components.RobotComponentBase;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;

//Knue
public class NetworkTableTest extends RobotComponentBase
{
	int time;
	int val;
	int val2;
	
	public void robotInit()
	{
		NetworkTable.setTeam(1318);
	}
	
	public void teleopPeriodic()
	{
		if(time++ % 50 == 0)
		{
			synchronized(NetworkTable.getTable("tst"))
			{
				NetworkTable.getTable("test").putString("+", String.valueOf(val++));
			}
		}
		if(time % 2000 == 0)
		{
			synchronized(NetworkTable.getTable("tst"))
			{
				NetworkTable.getTable("test").putString("-", String.valueOf(val2--));
			}
		}
	}
	
	public void disabledInit()
	{
		val = 0;
	}
}
