package org.usfirst.frc1318.components;

import org.usfirst.frc1318.generic.reference.GamePad;
import org.usfirst.frc1318.generic.reference.PS2Controller;
import org.usfirst.frc1318.generic.shared.GamePadData;
import org.usfirst.frc1318.generic.shared.ReferenceData;
import org.usfirst.frc1318.generic.shared.constants.ButtonRef;
import org.usfirst.frc1318.generic.shared.constants.PortRef;

public class GamePadReader extends RobotComponentBase{
	private GamePad gamePad;
	
	public void robotInit() {
		gamePad = PS2Controller.create(PortRef.GAMEPAD);
	}
	
	public void teleopPeriodic() {
		//update right button
		ReferenceData.getInstance().getGamePadData().setLiftUp(gamePad.getRawButton(ButtonRef.LIFT_UP));
		//System.out.println("Right Button");
		
		//update left button;
		ReferenceData.getInstance().getGamePadData().setLiftDown(gamePad.getRawButton(ButtonRef.LIFT_DOWN));
		//System.out.println("Left Button");
	}
}

