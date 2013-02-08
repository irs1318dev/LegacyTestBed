package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.PID;
import org.usfirst.frc1318.utils.DriverStationPrint;

public class DriveTrain2JoysticksCalculator extends RobotComponentBase {

	DriverStationPrint driverStationPrint;

	// Encoder rightEnc, leftEnc; => not needed
	PID rightPID, leftPID;

	// find and set PID constants
	// rightPid = new PID(kp, ki, kd, kf);
	// rightPid.setKFade(kFade);
	// same thing for left, probably same constants }all not needed

	// input data to PIDs

	// set variable in data to be read by

	public void robotInit() {
		driverStationPrint = new DriverStationPrint();
	}

	public void teleopPeriodic() {

		ReferenceData
				.getInstance()
				.getDriveTrainData()
				.setLeftSpeedSetPoint(
						ReferenceData.getInstance().getJoystickData()
								.getJoystickLY());
		ReferenceData
				.getInstance()
				.getDriveTrainData()
				.setRightSpeedSetPoint(
						ReferenceData.getInstance().getJoystickData()
								.getJoystickRY());

	}

}
