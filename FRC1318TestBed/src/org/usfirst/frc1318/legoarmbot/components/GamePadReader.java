package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.legoarmbot.shared.constants.GamePadRef;
import org.usfirst.frc1318.legoarmbot.shared.constants.PortRef;
import org.usfirst.frc1318.legoarmbot.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.JoystickFilter;
import org.usfirst.frc1318.generic.reference.GamePad;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;

public class GamePadReader extends RobotComponentBase{
	
	private GamePad gamePad;
	
//	private Joystick joystick;
	
	
	private double deltaX;
	private double deltaY;
	private double closedFormX;
	private double closedFormY;
	private boolean rightJoyStickActive;
	private boolean rightJoyStickActiveLastPressed;

	public void teleopPeriodic()
	{

		if(gamePad.getRawButton(GamePadRef.CHANGE_JOYSTICK_MODE)) { //if the button is pressed
			if(!rightJoyStickActiveLastPressed) { //if the button was not pressed last time this was run
				rightJoyStickActive = !rightJoyStickActive; //toggle the state
			}
			rightJoyStickActiveLastPressed = gamePad.getRawButton(GamePadRef.CHANGE_JOYSTICK_MODE);
		}
		if(rightJoyStickActive) {
			deltaX = (gamePad.getXRight());
			deltaY = (gamePad.getYRight());
		} else {
			closedFormX = (gamePad.getXLeft());
			closedFormY = (gamePad.getYLeft());
		}
		
		ReferenceData.getInstance().getUserInputData().setDeltaX(deltaX);
		ReferenceData.getInstance().getUserInputData().setDeltaY(deltaY);
		ReferenceData.getInstance().getUserInputData().setClosedFormX(closedFormX);
		ReferenceData.getInstance().getUserInputData().setClosedFormY(closedFormY);
		ReferenceData.getInstance().getUserInputData().setRightJoyStickActive(rightJoyStickActive);
		
	}
	
	public void robotInit(){
		gamePad = GamePad.create(PortRef.GAMEPAD);
//		joystick = new Joystick(PortRef.JOYSTICK_L);
	}
}





