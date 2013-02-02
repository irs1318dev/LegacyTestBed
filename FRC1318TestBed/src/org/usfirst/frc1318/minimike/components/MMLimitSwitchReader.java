package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.shared.MMLimitSwitchData;
import org.usfirst.frc1318.minimike.shared.constants.MMPortRef;

import edu.wpi.first.wpilibj.DigitalInput;

public class MMLimitSwitchReader extends RobotComponentBase{
	
	final int RIGHT_PORT = MMPortRef.RIGHT_LIMIT_SWITCH;
	final int LEFT_PORT = MMPortRef.LEFT_LIMIT_SWITCH;
	
	DigitalInput rightSwitch = null;
	DigitalInput leftSwitch = null;
	
	public void robotInit(){
		rightSwitch = new DigitalInput(MMPortRef.SIDECAR_PORT, RIGHT_PORT);
		leftSwitch = new DigitalInput(MMPortRef.SIDECAR_PORT, LEFT_PORT);
	}
	
	public void teleopPeriodic(){
		System.out.println("RightSwitch: " + rightSwitch.get()+ ", LeftSwitch: " + leftSwitch.get());
		MMLimitSwitchData.getInstance().setRightState(rightSwitch.get());
		MMLimitSwitchData.getInstance().setLeftState(leftSwitch.get());
	}
}
