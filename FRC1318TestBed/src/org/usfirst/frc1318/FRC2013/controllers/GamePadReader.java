package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.ButtonRef;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;
import org.usfirst.frc1318.generic.reference.PS2Controller;

public class GamePadReader extends RobotComponentBase{
	private GamePad gamePad;
	
	public void robotInit() {
		gamePad = PS2Controller.create(PortRef.GAMEPAD);
	}
	
	public void teleopPeriodic() {
		
		ReferenceData.getInstance().getJoystickData().setLiftUp(gamePad.getRawButton(ButtonRef.LIFT_UP));
		ReferenceData.getInstance().getJoystickData().setLiftDown(gamePad.getRawButton(ButtonRef.LIFT_DOWN));
		
		double[] joysticks = {gamePad.getYLeft(), gamePad.getYRight(), gamePad.getXLeft(), gamePad.getXRight()};
		
		for(int i = 0; i < joysticks.length; i++){
			joysticks[i] = Math.min(joysticks[i], 1);
			joysticks[i] = Math.max(joysticks[i], -1);
			//TODO turn .1 into a constant
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

	}

	public void setGamePad(GamePad newGamePad) {
		gamePad = newGamePad;
	}
}

