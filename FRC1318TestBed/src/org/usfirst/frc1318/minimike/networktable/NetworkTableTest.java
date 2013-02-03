package org.usfirst.frc1318.minimike.networktable;

import java.io.IOException;

import org.usfirst.frc1318.components.RobotComponentBase;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Knue
public class NetworkTableTest extends RobotComponentBase
{
	int time;
	int val;
	int val2;
	
	public void robotInit()
	{
		System.out.println("[Network-Table] I am a server: "+ NetworkTable.getTable("tst").isServer());
	}
	
	public void teleopPeriodic()
	{
		if(time++ % 50 == 0)
		{
			synchronized(NetworkTable.getTable("tst"))
			{
				SmartDashboard.putNumber("+", val++);
			}
		}
		if(time % 200 == 0)
		{
			synchronized(NetworkTable.getTable("tst"))
			{
				SmartDashboard.putNumber("-", val2--);
			}
		}
	}
	
	public void disabledInit()
	{
		val = 0;
	}
}
