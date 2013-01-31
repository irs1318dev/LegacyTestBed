package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;
import org.usfirst.frc1318.generic.reference.PS2Controller;
import org.usfirst.frc1318.minimike.shared.MMGamePadData;
import org.usfirst.frc1318.minimike.shared.MMSensors;
import org.usfirst.frc1318.minimike.shared.constants.MMButtonRef;
import org.usfirst.frc1318.minimike.shared.constants.MMPortRef;
import org.usfirst.frc1318.testbed.shared.TBSolenoidData;

import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc1318.components.RobotComponentBase;

public class MMGamePadReader extends RobotComponentBase{
	private GamePad gamepad;
	
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
		if(gamepad.getRawButton(MMButtonRef.ROTATE_RIGHT)){
			MMGamePadData.getInstance().setRightButton(true);
		}else{
			MMGamePadData.getInstance().setRightButton(false);
		}
		
		//update left button
		if(gamepad.getRawButton(MMButtonRef.ROTATE_LEFT)){
			MMGamePadData.getInstance().setLeftButton(true);
		}else{
			MMGamePadData.getInstance().setLeftButton(false);
		}
	}
}
