package org.usfirst.frc1318.generic.networktable;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;

public class IRSTable
{
	public static void putBoolean(String key, boolean value)
	{
		try
		{
			if(SmartDashboard.getBoolean(key) != value)
				SmartDashboard.putBoolean(key, value);
		}
		catch (NetworkTableKeyNotDefined ex)
		{
			SmartDashboard.putBoolean(key, value);
		}
	}
	
	public static void putNumber(String key, double value)
	{
		try
		{
			if(SmartDashboard.getNumber(key) != value)
				SmartDashboard.putNumber(key, value);
		}
		catch (NetworkTableKeyNotDefined ex)
		{
			SmartDashboard.putNumber(key, value);
		}
	}

	public static void putString(String key, String value)
	{
		try
		{
			if(SmartDashboard.getString(key) != value)
				SmartDashboard.putString(key, value);
		}
		catch (NetworkTableKeyNotDefined ex)
		{
			SmartDashboard.putString(key, value);
		}
	}

	public static boolean getBoolean(String key)
	{
		return SmartDashboard.getBoolean(key);
	}
	
	public static double getNumber(String key)
	{
		return SmartDashboard.getNumber(key);
	}
	
	public static String getString(String key)
	{
		return SmartDashboard.getString(key);
	}
}