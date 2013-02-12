package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.utils.DriverStationPrint;

public class DriveTrain1JoystickCalculator extends RobotComponentBase {
	
	private double K1 = 1;
	private double K2 = 1;
	
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
				
		double y = ReferenceData.getInstance().getJoystickData().getJoystickLY();
		double x = ReferenceData.getInstance().getJoystickData().getJoystickLX();
		
		double speedL = (K1 * x) + (K2 * y);
		double speedR = (K3 * x) + (K4 * y);
		
		//TODO scale L, R to be the same 
		if(Math.abs(speedL)>1){
			speedR = speedR/Math.abs(speedL);
			speedL = speedL/Math.abs(speedL);
		}
		if (Math.abs(speedR)>1){
			speedL = speedL/Math.abs(speedR);
			speedR = speedR/Math.abs(speedR);
		}
		// find the max of L, R using abs values
		// if L max, set absL, L = 1, R = R/absL
		// if R max, set absR, R = 1, L = L/absR
		/*
		speedL = Math.max(speedL, -1);
		speedL = Math.min(speedL, 1);
		speedR = Math.max(speedR, -1);
		speedR = Math.min(speedR, 1);
		*/
		
		ReferenceData.getInstance().getDriveTrainData().setLeftSpeedSetPoint(speedL);
		ReferenceData.getInstance().getDriveTrainData().setRightSpeedSetPoint(speedR);
		
		
		
	}

}
