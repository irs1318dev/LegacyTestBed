package org.usfirst.frc1318.components.minimike;

import org.usfirst.frc1318.shared.constants.minimike.MMPortRef;
import org.usfirst.frc1318.shared.minimike.MMLimitSwitchData;

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
		boolean right = rightSwitch.get();
		boolean left = leftSwitch.get();
		int state = 3;
		
		if(right && left){
			state = MMLimitSwitchData.ERROR;
		}else if(right && !left){
			state = MMLimitSwitchData.HIT_RIGHT;
		}else if(!right && left){
			state = MMLimitSwitchData.HIT_LEFT;
		}else{
			state = MMLimitSwitchData.NOT_HIT;
		}
		
		MMLimitSwitchData.setData(state);
	}
}
