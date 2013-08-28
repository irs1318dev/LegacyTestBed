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
	private boolean joyStickMode;

	public void teleopPeriodic()
	{
		
		deltaX = (gamePad.getXRight());
		deltaY = (gamePad.getYRight());
		closedFormX = (gamePad.getXLeft());
		closedFormY = (gamePad.getYLeft());
		
		ReferenceData.getInstance().getUserInputData().setDeltaX(deltaX);
		ReferenceData.getInstance().getUserInputData().setDeltaY(deltaY);
		ReferenceData.getInstance().getUserInputData().setClosedFormX(closedFormX);
		ReferenceData.getInstance().getUserInputData().setClosedFormY(closedFormY);
		
	}
	
	public void robotInit(){
		gamePad = GamePad.create(PortRef.GAMEPAD);
//		joystick = new Joystick(PortRef.JOYSTICK_L);
	}
}
