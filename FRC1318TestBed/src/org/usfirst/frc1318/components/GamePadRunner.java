package org.usfirst.frc1318.components;

import org.usfirst.frc1318.shared.constants.PortRef;

public class GamePadRunner extends RobotComponentBase {
	TBGamePadReader reader;
	public void robotInit() {
		synchronized (Sensors.getInstance()) {
			Sensors.getInstance().setCopilotGamePad(GamePad.create(PortRef.COPILOT_PAD));
			Sensors.getInstance().setPilotGamePad(PS2Controller.create(PortRef.PILOT_PAD));
		}
		reader = new TBGamePadReader(0.1, new Quadratic());
		reader.init();		
	}
	
	public void teleopPeriodic() {
		reader.read();
	}
	
	public void autonomousPeriodic() {
		//unimplemented--must use autonomous controller
	}
}
