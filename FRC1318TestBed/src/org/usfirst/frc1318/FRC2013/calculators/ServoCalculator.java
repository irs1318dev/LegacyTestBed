package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ServoData;
import org.usfirst.frc1318.FRC2013.shared.UserInputData;
import org.usfirst.frc1318.components.RobotComponentBase;

/**
 * 
 * @author Graham
 *
 *	Sets the state of the servo through shooter data based on input from 
 *	UserInputData
 *
 */
public class ServoCalculator extends RobotComponentBase {
	UserInputData userInput;
	ServoData servoData;
	
	public void robotInit() {
		userInput = ReferenceData.getInstance().getUserInputData();
		servoData = ReferenceData.getInstance().getServoData();
	}

	public void teleopPeriodic() {
		
		if(userInput.getServoDown()) {
			servoData.setState(servoData.DOWN);
		}
		else if(userInput.getServoUp()) {
			servoData.setState(servoData.UP);
		}
	}
	
}
