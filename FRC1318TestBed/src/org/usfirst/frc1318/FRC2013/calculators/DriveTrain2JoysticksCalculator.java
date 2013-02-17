package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.utils.DriverStationPrint;

public class DriveTrain2JoysticksCalculator extends RobotComponentBase {

	//DriverStationPrint driverStationPrint;

	public void robotInit() {
		//driverStationPrint = new DriverStationPrint();
	}

	public void teleopPeriodic() {
		
		// Left side is negative due to the motor arrangement

		ReferenceData
				.getInstance()
				.getDriveTrainData()
				.setLeftSpeedSetPoint(
						- ReferenceData.getInstance().getUserInputData().getJoystickLeft()
						);
		ReferenceData
				.getInstance()
				.getDriveTrainData()
				.setRightSpeedSetPoint(
						ReferenceData.getInstance().getUserInputData().getJoystickRight()
								);

	}

}
