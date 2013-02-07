package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.ButtonRef;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickReader extends RobotComponentBase{
	
	private Joystick joystickL;
	private Joystick joystickR;
	
	public void robotInit(){
		joystickL = new Joystick(PortRef.JOYSTICK_L);
		joystickR = new Joystick(PortRef.JOYSTICK_R);
	}
	
	public void robotTeleop(){
		
		ReferenceData.getInstance().getJoystickData().setJoystickL(joystickL.getY());
		ReferenceData.getInstance().getJoystickData().setJoystickR(joystickR.getY());
		
	}
	
	public void setJoystick(Joystick j1, Joystick j2){
		joystickL = j1;
		joystickR = j2;
	}
}