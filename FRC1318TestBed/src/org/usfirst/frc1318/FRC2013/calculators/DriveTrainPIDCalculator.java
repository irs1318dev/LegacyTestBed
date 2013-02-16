package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.PID;

public class DriveTrainPIDCalculator extends RobotComponentBase{
	
	//TODO wright test
	
	PID rightPID;
	PID leftPID;
	long count;
	
	public void robotInit(){
//		rightPID = new PID(0, 0, 0, 1);
		//flip sign if not work right after pull
		rightPID = new PID(0, 0, -0.001, 0);
//		rightPID = new PID(0, 0, 0.0, 0);
		rightPID.setKScale(2800); 
		
//		all left negative
//		leftPID = new PID(0, 0, 0, -1);
		leftPID = new PID(0, 0, -0.001, 0);
//		leftPID = new PID(0, 0, 0.0, 0);
		leftPID.setKScale(2800);
		//TODO ask James about values
		count = 0;
	}
	
	public void teleopPeriodic(){
		
		double rset =ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint();
		double rencv = ReferenceData.getInstance().getDriveTrainData().getRightEncoder();
		double rkf = 0;
		double rkd = 0.001;
		double rkscale = 2800;
		double rightPIDVal = rkf * rset + rkd*(rkscale * rset - rencv);

		
		double lset =ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint();
		double lencv = ReferenceData.getInstance().getDriveTrainData().getLeftEncoder();
		double lkf = 0;
		double lkd = 0.001;
		double lkscale = 2800;

		double leftPIDVal = lkf * lset + lkd*(lkscale * lset - lencv);

		if (count%100==0) {
			System.out.println("lset="+lset+" , rset="+rset);
			System.out.println("lencv="+lencv+" , rencv="+rencv);
			System.out.println("LPID="+ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed()
					+", RPID="+ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed()
					);
		}
		count++;
		//		rightPID.setSetpoint(ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint());
//		leftPID.setSetpoint(ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint());
//		
//		System.out.println("LSet="+ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint()
//				+", RSet="+ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint()
//				);
//
//		rightPID.input(ReferenceData.getInstance().getDriveTrainData().getRightEncoder());
//		leftPID.input(ReferenceData.getInstance().getDriveTrainData().getLeftEncoder());
//		
//		double rightPIDVal = rightPID.getOutput();
		                    
		
//		double leftPIDVal = leftPID.getOutput();

		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(rightPIDVal);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(leftPIDVal);

//		System.out.println("LPIDConst:"+leftPID.toString()
//				+", RPIDConst:"+rightPID.toString()
//				);

	}
	
	//PID.setSetpoint(what you want the encoder to read = what the joystick says it should read) 
	//PID.input(acutal angular velocity)
	//PID.getOutPut() = value to give motors 
}
