package org.usfirst.frc1318.generic.networktable;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class IRSNetTable 
{
	public static final String tablename = "table";
	
 	public static void init()
	{
		NetworkTable.setTeam(1318);
	}
	
	public static void putBoolean(String key, boolean value)
	{
		NetworkTable.getTable(tablename).putBoolean(key, value);
	}
	
	public static void putDouble(String key, double value)
	{
		NetworkTable.getTable(tablename).putDouble(key, value);
	}
	
	public static void putInt(String key, int value)
	{
		NetworkTable.getTable(tablename).putInt(key, value);
	}
	
	public static void putString(String key, String value)
	{
		NetworkTable.getTable(tablename).putString(key, value);
	}
	
	public static void putValue(String key, Object value)
	{
		NetworkTable.getTable(tablename).putValue(key, value);
	}
}
