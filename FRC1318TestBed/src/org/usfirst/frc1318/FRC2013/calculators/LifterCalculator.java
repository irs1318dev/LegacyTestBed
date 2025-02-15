package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

public class LifterCalculator extends RobotComponentBase {
	
	public void teleopPeriodic() {
		if (ReferenceData.getInstance().getUserInputData().getLiftDown()) {
			ReferenceData.getInstance().getLifterData().setShouldLift(false);
		} else if (ReferenceData.getInstance().getUserInputData().getLiftUp()) {
			ReferenceData.getInstance().getLifterData().setShouldLift(true);
		}
	}
}
