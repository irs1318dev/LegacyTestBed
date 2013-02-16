package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

public class DriveTrainNoPIDCalculator extends RobotComponentBase
{
	public void teleopPeriodic() {
			

		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(ReferenceData
				.getInstance()
				.getDriveTrainData()
				.getRightSpeedSetPoint());
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(ReferenceData
				.getInstance()
				.getDriveTrainData()
				.getLeftSpeedSetPoint());	

	}
}
