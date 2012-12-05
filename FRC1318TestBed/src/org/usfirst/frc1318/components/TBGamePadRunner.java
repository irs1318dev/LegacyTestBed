package org.usfirst.frc1318.runners.components;

import org.usfirst.frc1318.reference.GamePad;
import org.usfirst.frc1318.reference.GamePadReader;
import org.usfirst.frc1318.reference.PS2Controller;
import org.usfirst.frc1318.reference.Quadratic;
import org.usfirst.frc1318.runners.Runner;
import org.usfirst.frc1318.shared.constants.PortRef;
import org.usfirst.frc1318.shared.data.Sensors;

public class TBGamePadRunner extends Runner {
	GamePadReader reader;
	public void robotInit() {
		synchronized (Sensors.getInstance()) {
			Sensors.getInstance().setCopilotGamePad(GamePad.create(PortRef.COPILOT_PAD));
			Sensors.getInstance().setPilotGamePad(PS2Controller.create(PortRef.PILOT_PAD));
		}
		reader = new GamePadReader(0.1, new Quadratic());
		reader.init();		
	}
	
	public void teleopPeriodic() {
		reader.read();
	}
	
	public void autonomousPeriodic() {
		//unimplemented--must use autonomous controller
	}
}
