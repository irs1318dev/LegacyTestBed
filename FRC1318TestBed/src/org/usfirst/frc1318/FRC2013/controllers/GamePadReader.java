package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.ButtonRef;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;
import org.usfirst.frc1318.generic.reference.PS2Controller;

public class GamePadReader extends RobotComponentBase{
	private GamePad gamePad;
	private double deadZone = 0.1;
	
	public void robotInit() {
		gamePad = GamePad.create(PortRef.GAMEPAD);
	}
	
	public void teleopPeriodic() {
		
		ReferenceData.getInstance().getGamePadData().setLiftUp(gamePad.getRawButton(ButtonRef.LIFT_UP));
		ReferenceData.getInstance().getGamePadData().setLiftDown(gamePad.getRawButton(ButtonRef.LIFT_DOWN));
		
		double[] joysticks = {gamePad.getYLeft(), gamePad.getYRight(), gamePad.getXLeft(), gamePad.getXRight()};
		
		for(int i = 0; i < joysticks.length; i++){
			joysticks[i] = Math.min(joysticks[i], 1);
			joysticks[i] = Math.max(joysticks[i], -1);
			//TODO turn .1 into a constant
			if(joysticks[i] > .1){
				joysticks[i] = ((joysticks[i] - deadZone)/(1-deadZone));
			}else if(joysticks[i] < -.1){
				joysticks[i] = ( (10.0 * joysticks[i]) + 1) / 9;
			}else{
				joysticks[i] = 0;
			}
		}
		

		ReferenceData.getInstance().getGamePadData().setJoystickLY(joysticks[0]);
		ReferenceData.getInstance().getGamePadData().setJoystickRY(joysticks[1]);
		ReferenceData.getInstance().getGamePadData().setJoystickLX(joysticks[2]);
		ReferenceData.getInstance().getGamePadData().setJoystickRX(joysticks[3]);
		ReferenceData.getInstance().getGamePadData().setLiftUp(gamePad.getRawButton(ButtonRef.LIFT_UP));
		ReferenceData.getInstance().getGamePadData().setLiftDown(gamePad.getRawButton(ButtonRef.LIFT_DOWN));
		ReferenceData.getInstance().getGamePadData().setShooterDown(gamePad.getRawButton(ButtonRef.SHOOTER_DOWN));
		ReferenceData.getInstance().getGamePadData().setShooterUp(gamePad.getRawButton(ButtonRef.SHOOTER_UP));
		ReferenceData.getInstance().getGamePadData().setShooterSpeedDown(gamePad.getRawButton(ButtonRef.SHOOTER_SPEED_DOWN));
		ReferenceData.getInstance().getGamePadData().setShooterSpeedUp(gamePad.getRawButton(ButtonRef.SHOOTER_SPEED_UP));
		//ReferenceData.getInstance().getGamePadData().setShooterFire(gamePad.getRawButton(ButtonRef.SHOOTER_FIRE));
//		System.out.println(ReferenceData.getInstance().getGamePadData().getJoystickLX());
//		System.out.println(ReferenceData.getInstance().getGamePadData().getJoystickRX());
//		System.out.println(ReferenceData.getInstance().getGamePadData().getJoystickLY());
//		System.out.println(ReferenceData.getInstance().getGamePadData().getJoystickRY());
	}

	public void setGamePad(GamePad newGamePad) {
		gamePad = newGamePad;
	}
}

