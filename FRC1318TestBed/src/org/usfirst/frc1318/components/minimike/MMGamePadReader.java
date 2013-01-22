package org.usfirst.frc1318.components.minimike;

import org.usfirst.frc1318.reference.GamePad;
import org.usfirst.frc1318.reference.PS2Controller;
import org.usfirst.frc1318.shared.TBSolenoidData;
import org.usfirst.frc1318.shared.constants.minimike.MMButtonRef;
import org.usfirst.frc1318.shared.constants.minimike.MMPortRef;
import org.usfirst.frc1318.shared.minimike.MMGamePadData;
import org.usfirst.frc1318.shared.minimike.MMSensors;

import edu.wpi.first.wpilibj.Solenoid;
import build.org.usfirst.frc1318.components.RobotComponentBase;

public class MMGamePadReader extends RobotComponentBase{
	GamePad gamepad;
	
	public void robotInit() {
		MMSensors.getInstance().setGamePad(PS2Controller.create(MMPortRef.GAMEPAD));
		
		try {
			gamepad = MMSensors.getInstance().getGamePad();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void teleopPeriodic() {
		//update right button
		if(gamepad.getRawButton(PS2Controller.PS2ButtonMap.R1)){
			MMGamePadData.setRightButton(true);
		}else{
			MMGamePadData.setRightButton(false);
		}
		
		//update left button
		if(gamepad.getRawButton(PS2Controller.PS2ButtonMap.L1)){
			MMGamePadData.setLeftButton(true);
		}else{
			MMGamePadData.setLeftButton(false);
		}
	}
}
