package org.usfirst.frc1318.testbed.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.*;
import org.usfirst.frc1318.generic.reference.GamePad.ButtonVals;
import org.usfirst.frc1318.generic.shared.ButtonData;
import org.usfirst.frc1318.generic.shared.KinematicData;
import org.usfirst.frc1318.generic.shared.Sensors;
import org.usfirst.frc1318.testbed.shared.TBGamepadData;
import org.usfirst.frc1318.testbed.shared.constants.TBButtonRef;
import org.usfirst.frc1318.testbed.shared.constants.TBPortRef;

import com.sun.squawk.util.MathUtils;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * 
 * TBGamePadReader 
 * 
 * This class is supposed to....(someone finish this sentence)
 * 
 * 
 *	***THIS CLASS IS NOT FINISHED***
 *		look for the blue marks by the scroll bar for TODO tags
 */


public class TBGamePadReader extends RobotComponentBase {
	public static final int NUM_GAME_PADS = 1;
	private ButtonData[] buttons = new ButtonData[NUM_GAME_PADS + 1];
	
	
	//TODO I don't know if these values are correct
	private final int PILOT_JS = 0;
	private final int COPILOT_JS = 1;
	
	Scale scale;
		
		
	public interface ButtonMap {
		int COMPRESSOR_TOGGLE = GamePad.ButtonVals.B;
		int KICK_BUTTON = ButtonVals.A;
		int MODE_TOGGLE = ButtonVals.Y;
	}
	
	
//	public TBGamePadReader(double value, Scale scale)
//	{
//		//TODO do something with double value. I can't tell what it's supposed to be for
//		this.scale = scale;
//	}

	public void robotInit() {
		GamePad pilotGamePad = GamePad.create(0); //TODO figure out how to initialize gamepad
		Sensors.getInstance().setPilotGamePad(pilotGamePad);
		setToggles();
	}
	
	
	public void teleopPeriodic() {
		read();
	}
	
	/**
	 * Buttons default to be press and hold. This method sets buttons that are toggles as such.
	 */
	private void setToggles() {
		buttons[ButtonMap.COMPRESSOR_TOGGLE].setButtonType(TBButtonRef.COMPRESSOR_TOGGLE, TBButtonRef.TOGGLE);
		buttons[ButtonMap.MODE_TOGGLE].setButtonType(TBButtonRef.MODE_TOGGLE, TBButtonRef.TOGGLE);
	}
	
	public void read() {
		synchronized (Sensors.getInstance().getPilotGamePad()) {
			GamePad pilot = Sensors.getInstance().getPilotGamePad();
			
			for(int i = 1; i <= GamePad.NUM_BUTTONS; i++) {
				buttons[PILOT_JS].isPressed(i, pilot.getRawButton(i));
			}
		}
		synchronized (Sensors.getInstance().getCopilotGamePad()) {
			
			
			for(int i = 1; i <= GamePad.NUM_BUTTONS; i++) {
				buttons[COPILOT_JS].isPressed(i, Sensors.getInstance().getCopilotGamePad().getRawButton(i));
			}
		}		
		writeVals();
	}

	private void writeVals() {
		
		//TODO none of this methods are implemented
		//TODO these arguments should be a TBGamePadData object, not null

		TBGamepadData.setKickButton(false);
		TBGamepadData.setModeToggle(true);
		
	}
	
	/*
	 * we don't have a set of joysticks for the kicker
	 * 
	 *
	private void copyVals(JoystickSetData joystickSetData) {
			buttons[PILOT_JS].copyTo(joystickSetData.getJoystickData(PILOT_JS).getButtons());
			buttons[COPILOT_JS].copyTo(joystickSetData.getJoystickData(COPILOT_JS).getButtons());		
	}
	*/
	
	private void writeMode(TBGamepadData gpData) {
		//TODO method not implemented
	}
	
	private void writeKick(TBGamepadData gpData) {
		//TODO method not implemented
	}
	
	private void writeCompressor(TBGamepadData gpData) {
		//TODO method not implemented
	}
}
