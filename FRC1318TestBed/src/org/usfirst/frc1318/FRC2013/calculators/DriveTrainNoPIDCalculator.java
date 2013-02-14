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

		System.out.println("rSetPoint="+
				 ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint()+", lSetPoint="
				+ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint());		

		System.out.println("rPID="+
		 ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed()+", lPID="
		+ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed());		

	}
}
