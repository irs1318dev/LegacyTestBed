package org.usfirst.frc1318.components;

public class TBHelloWorldRunner  extends RobotComponentBase{
	
	public void robotInit(){
		System.out.println("Hello World from Robot Init");
		
	}
	
	public void teleopPeriodic(){
		System.out.println("Hello World from TeleopPeriodic");
	}

}
