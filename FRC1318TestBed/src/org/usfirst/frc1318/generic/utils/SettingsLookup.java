package org.usfirst.frc1318.generic.utils;

import java.util.Vector;

/**
 * this class stores a vector of Settings objects
 * 		this vector is assumed to be in order
 * 
 * @author Graham
 *
 */
public class SettingsLookup {
	Vector settings;
	int current;
	
	SettingsLookup()
	{
		settings = new Vector();
	}
	/**
	 * @param newSetting new setting to add
	 */
	public void addSetting(double newSetting)
	{
		settings.addElement(new Settings(newSetting));
	}
	
	/**
	 * @return current setting
	 */
	public double getCurrent()
	{
		return ((Settings)settings.elementAt(current)).getValue();
	}
	
	
	/**
	 * increment setting
	 */
	public void up()
	{
		if(current < settings.size())
		{
			current++;
		}
	}
	
	/**
	 * Decrement setting
	 */
	public void down()
	{
		if(current >= 0)
		{
			current--;
		}
	}
	
}
