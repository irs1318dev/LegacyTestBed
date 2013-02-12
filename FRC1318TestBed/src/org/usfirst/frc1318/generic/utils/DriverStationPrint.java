package org.usfirst.frc1318.generic.utils;

import edu.wpi.first.wpilibj.DriverStationLCD;

public class DriverStationPrint 
{
	DriverStationLCD driverstation;
	String line1 = "";
	String line2 = "";
	String line3 = "";
	String line4 = "";
	String line5 = "";
	String line6 = "";
	public DriverStationPrint()
	{
		driverstation = DriverStationLCD.getInstance();
	}
	public void println(String message)
	{
		line6 = line5;
		line5 = line4;
		line4 = line3;
		line3 = line2;
		line2 = line1;
		line1 = message;
		driverstation.println(DriverStationLCD.Line.kMain6, 1, line1);
		driverstation.println(DriverStationLCD.Line.kUser2, 1, line2);
		driverstation.println(DriverStationLCD.Line.kUser3, 1, line3);
		driverstation.println(DriverStationLCD.Line.kUser4, 1, line4);
		driverstation.println(DriverStationLCD.Line.kUser5, 1, line5);
		driverstation.println(DriverStationLCD.Line.kUser6, 1, line6);
		driverstation.updateLCD();
	}
}
