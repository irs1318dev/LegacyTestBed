package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.ButtonRef;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;
import org.usfirst.frc1318.generic.shared.GamePadData;
import org.usfirst.frc1318.generic.reference.PS2Controller;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickReader extends RobotComponentBase{
	
	private Joystick joystickL;
	private Joystick joystickR;
	private GamePad gamePad;

	
	public void robotInit(){
		joystickL = new Joystick(PortRef.JOYSTICK_L);
		joystickR = new Joystick(PortRef.JOYSTICK_R);
		gamePad = PS2Controller.create(PortRef.GAMEPAD);
	}
	
	public void robotTeleop(){
		
		ReferenceData.getInstance().getJoystickData().setJoystickLY(joystickL.getY());
		ReferenceData.getInstance().getJoystickData().setJoystickRY(joystickR.getY());
		
		ReferenceData.getInstance().getJoystickData().setJoystickLX(joystickL.getX());
		ReferenceData.getInstance().getJoystickData().setJoystickRX(joystickR.getX());
				
		ReferenceData.getInstance().getJoystickData().setLiftUp(gamePad.getRawButton(ButtonRef.LIFT_UP));
		ReferenceData.getInstance().getJoystickData().setLiftDown(gamePad.getRawButton(ButtonRef.LIFT_DOWN));
	}
	
	public void setJoystick(Joystick j1, Joystick j2){
		joystickL = j1;
		joystickR = j2;
	}
}