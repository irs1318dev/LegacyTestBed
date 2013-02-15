package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.generic.shared.ReferenceData;

public class UserInputCalculator {
	//TODO: Do joysticks...
	
	private int liftDownIndex = 0;
	private int liftUpIndex = 1;
	private int shooterDownIndex = 2;
	private int shooterUpIndex = 3;
	private int shooterSpeedUpIndex = 4;
	private int shooterSpeedDownIndex = 5;
	
	private final int[] JOYSTICKBUTTONS = {};
	private final int[] PS2BUTTONS = {4, 3, 2, 1, 5, 8};
	/*
	private final byte[] ps21Joystick = {};
	private final byte[] joysticks1Joystick = {};
	private final byte[] ps22Joystick = {};
	private final byte[] ps22joystick = {};
	*/
	
	//Active User Input TODO: set activeJoysticks
	private int[] activeButtons = PS2BUTTONS;
	private int[] activeJoysticks;
	
	//TODO: set actual vals...
	
	public void teleopPeriodic(){
		ReferenceData.getInstance().getUserInputData().setLiftDown();
		ReferenceData.getInstance().getUserInputData().setLiftUp();
		ReferenceData.getInstance().getUserInputData().setShooterDown();
	}
	
	
	
	}
}
