package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.LifterData;
import org.usfirst.frc1318.components.RobotComponentBase;

public class LifterCalculator extends RobotComponentBase {
	LifterData lifterData;
	
	boolean shouldLift;
	
	
	public void teleopPeriodic() {
		lifterData = new LifterData();
		
		
	}
}
