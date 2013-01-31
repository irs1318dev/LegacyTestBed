package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.minimike.shared.MMLimitSwitchData;
import org.usfirst.frc1318.minimike.shared.constants.MMPortRef;

import edu.wpi.first.wpilibj.DigitalInput;

public class MMLimitSwitchReader {
	
	final int RIGHT_PORT = MMPortRef.RIGHT_LIMIT_SWITCH;
	final int LEFT_PORT = MMPortRef.LEFT_LIMIT_SWITCH;
	
	DigitalInput rightSwitch = null;
	DigitalInput leftSwitch = null;
	
	public void robotInit(){
		rightSwitch = new DigitalInput(RIGHT_PORT);
		leftSwitch = new DigitalInput(LEFT_PORT);
	}
	
	public void teleopPeriodic(){
		MMLimitSwitchData.getInstance().setRightState(rightSwitch.get());
		MMLimitSwitchData.getInstance().setLeftState(leftSwitch.get());
	}
}
