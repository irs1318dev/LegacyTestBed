package org.usfirst.frc1318.generic.utils;

public class Settings {
	double value;
	
	public Settings(double setting) {
		value = setting;
	}

	public double getValue()
	{return value;}
	
	public void setValue(double value)
	{this.value = value;}
}
