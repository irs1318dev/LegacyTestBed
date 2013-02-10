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
		ReferenceData.getInstance().getJoystickData().setJoystickLY(gamePad.getYLeft());
		ReferenceData.getInstance().getJoystickData().setJoystickRY(gamePad.getYRight());
		ReferenceData.getInstance().getJoystickData().setJoystickLX(gamePad.getXLeft());
		ReferenceData.getInstance().getJoystickData().setJoystickRX(gamePad.getXRight());

	}

	public void setGamePad(GamePad newGamePad) {
		gamePad = newGamePad;
	}
}

