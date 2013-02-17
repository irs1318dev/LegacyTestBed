package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.utils.DriverStationPrint;

public class DriveTrain1JoystickCalculator extends RobotComponentBase {
	
	//???eden: K vals help rep speed to be fed into robot ???
	
	private double K1 = 2.5;
	private double K2 = 0.9;
	
	private double K3 = K1;
	private double K4 = -K2;

	public void robotInit() {
	}
	
	public void setXScaleFactor(double xScaleFactor) {
		K1 = xScaleFactor;
		K3 = xScaleFactor;
	}
	public void setYScaleFactor(double yScaleFactor) {
		K2 = yScaleFactor;
		K4 = -yScaleFactor;
	}
	
	public void teleopPeriodic(){
		
		//ReferenceData.getInstance().getDriveTrainData().setLeftSpeedSetPoint()
				
		double y = ReferenceData.getInstance().getUserInputData().getJoystickY();
		double x = ReferenceData.getInstance().getUserInputData().getJoystickX();
		
		double speedL = (K1 * x) + (K2 * y);
		double speedR = (K3 * x) + (K4 * y);
		
		ReferenceData.getInstance().getDriveTrainData().setLeftSpeedSetPoint(speedL);
		ReferenceData.getInstance().getDriveTrainData().setRightSpeedSetPoint(speedR);
		
		
		
	}

}
