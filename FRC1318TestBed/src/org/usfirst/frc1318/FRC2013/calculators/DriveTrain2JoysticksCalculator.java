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
		
		//TODO make one side negitive

		ReferenceData
				.getInstance()
				.getDriveTrainData()
				.setLeftSpeedSetPoint(
						/*ReferenceData.getInstance().getJoystickData()
								.getJoystickLY()*/
						ReferenceData.getInstance().getUserInputData().getJoystickAxis1()
						);
		ReferenceData
				.getInstance()
				.getDriveTrainData()
				.setRightSpeedSetPoint(
						/*ReferenceData.getInstance().getJoystickData()
								.getJoystickRY()*/
						ReferenceData.getInstance().getUserInputData().getJoystickAxis2()
								);

	}

}
