package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.PID;

public class DriveTrainPIDCalculator extends RobotComponentBase{
	
	//TODO wright test
	
	PID rightPID;
	PID leftPID;
	
	public void robotInit(){
		//rightPID = new PID(0, 0, 0, 1);
		//flip sign if not work right after pull
		rightPID = new PID(0, 0, -0.001, 0);
		rightPID.setKScale(1250);
		
		//all left negative
		leftPID = new PID(0, 0, 0.0, 0);
		leftPID.setKScale(1250);
//		leftPID = new PID(0, 0, 0, -1);
		//TODO ask James about values
	}
	
	public void teleopPeriodic(){
		rightPID.setSetpoint(ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint());
		leftPID.setSetpoint(ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint());
		
		rightPID.input(ReferenceData.getInstance().getDriveTrainData().getLeftEncoder());
		leftPID.input(ReferenceData.getInstance().getDriveTrainData().getLeftEncoder());
		
		double rightPIDVal = rightPID.getOutput();
		rightPIDVal = Math.min(rightPIDVal, 1);
		rightPIDVal = Math.max(rightPIDVal, -1);
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(rightPIDVal);
		
		double leftPIDVal = leftPID.getOutput();
		leftPIDVal = Math.min(leftPIDVal, 1);
		leftPIDVal = Math.max(leftPIDVal, -1);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(leftPIDVal);

	}
	
	//PID.setSetpoint(what you want the encoder to read = what the joystick says it should read) 
	//PID.input(acutal angular velocity)
	//PID.getOutPut() = value to give motors 
}
