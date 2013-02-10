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
	
	public void teleopPeriodic(){
		
		double[] joysticks = {joystickL.getY(), joystickR.getY(), joystickL.getX(), joystickR.getX()};
		
		for(int i = 0; i < joysticks.length; i++){
			joysticks[i] = Math.min(joysticks[i], 1);
			joysticks[i] = Math.max(joysticks[i], -1);
			if(joysticks[i] > .1){
				joysticks[i] = ( (10.0 * joysticks[i]) - 1 ) / 9;
			}else if(joysticks[i] < -.1){
				joysticks[i] = ( (10.0 * joysticks[i]) + 1) / 9;
			}else{
				joysticks[i] = 0;
			}
		}
		
		ReferenceData.getInstance().getJoystickData().setJoystickLY(joysticks[0]);
		ReferenceData.getInstance().getJoystickData().setJoystickRY(joysticks[1]);
		
		ReferenceData.getInstance().getJoystickData().setJoystickLX(joysticks[2]);
		ReferenceData.getInstance().getJoystickData().setJoystickRX(joysticks[3]);
				
		ReferenceData.getInstance().getJoystickData().setLiftUp(joystickL.getRawButton(ButtonRef.LIFT_UP));
		ReferenceData.getInstance().getJoystickData().setLiftDown(joystickL.getRawButton(ButtonRef.LIFT_DOWN));
	}
	
	public void setJoystick(Joystick j1, Joystick j2){
		joystickL = j1;
		joystickR = j2;
	}
}