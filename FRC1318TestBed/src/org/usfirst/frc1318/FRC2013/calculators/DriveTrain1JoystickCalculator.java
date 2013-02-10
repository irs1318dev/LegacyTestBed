package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.utils.DriverStationPrint;

public class DriveTrain1JoystickCalculator {
	
	private final int K1 = 1;
	private final int K2 = 1;
	
	private final int K3 = K1;
	private final int K4 = -K2;
	
	DriverStationPrint driverStationPrint;

	public void robotInit() {
		driverStationPrint = new DriverStationPrint();
	}
	
	public void teleopPeriodic(){
		
		//ReferenceData.getInstance().getDriveTrainData().setLeftSpeedSetPoint()
				
		double y = ReferenceData.getInstance().getJoystickData().getJoystickLY();
		double x = ReferenceData.getInstance().getJoystickData().getJoystickLX();
		
		ReferenceData.getInstance().getDriveTrainData().setLeftSpeedSetPoint((K1 * x) + (K2 * y));
		ReferenceData.getInstance().getDriveTrainData().setRightSpeedSetPoint((K3 * x) + (K4 * y));
		
		
	}

}
