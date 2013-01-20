package org.usfirst.frc1318.components;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;

public class TBHelloWorldRunner  extends RobotComponentBase{
	
	public void robotInit(){
		System.out.println("Hello World from Robot Init 2");
		DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Hello World from Robot Init 2");
		DriverStationLCD.getInstance().updateLCD();
	}
	
	public void teleopPeriodic(){
		System.out.println("Hello World from TeleopPeriodic 2");
		DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Hello World from Teleop Periodic 2");
		DriverStationLCD.getInstance().updateLCD();
	}

}
