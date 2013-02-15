package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.reference.NTRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.generic.networktable.IRSTable;


public class NetworkTableRunner extends RobotComponentBase
{
	int val = 0;
	public void robotInit()
	{
		System.out.println("Network Table is ready!");
	}
	
	public void teleopPeriodic() 
	{
		if(val++ % 10 == 0)
		{
			driveTrainData();
			gamePadData();
			joystickData();
			lifterData();
			lifterLimitSwitchData();
			shooterData();
		}
	}
	
	private void driveTrainData()
	{
		IRSTable.putNumber(NTRef.DriveTrain_RightEncoder, ReferenceData.getInstance().getDriveTrainData().getRightEncoder());
		IRSTable.putNumber(NTRef.DriveTrain_LeftEncoder, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder());
		IRSTable.putNumber(NTRef.DriveTrain_RightSetPoint, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint());
		IRSTable.putNumber(NTRef.DriveTrain_RightPIDSpeed, ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed());
		IRSTable.putNumber(NTRef.DriveTrain_LeftPIDSpeed, ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed());
	}
	
	private void gamePadData()
	{
		
	}
	
 	private void joystickData()
	{
 		IRSTable.putNumber(NTRef.Joystick_LeftStickY, ReferenceData.getInstance().getJoystickData().getJoystickLY());
 		IRSTable.putNumber(NTRef.JoyStick_RightStickY, ReferenceData.getInstance().getJoystickData().getJoystickRY());
 		IRSTable.putNumber(NTRef.JoyStick_LeftStickX, ReferenceData.getInstance().getJoystickData().getJoystickLX());
 		IRSTable.putNumber(NTRef.JoyStick_RightStickX, ReferenceData.getInstance().getJoystickData().getJoystickRX());
 		IRSTable.putBoolean(NTRef.JoyStick_LiftUp, ReferenceData.getInstance().getJoystickData().getLiftUp());
 		IRSTable.putBoolean(NTRef.JoyStick_LiftDown, ReferenceData.getInstance().getJoystickData().getLiftDown());
	}
 	
 	private void lifterData()
 	{
 		IRSTable.putBoolean(NTRef.Lifter_ShouldLift, ReferenceData.getInstance().getLifterData().getShouldLift());
 	}

 	private void lifterLimitSwitchData()
 	{
 		IRSTable.putBoolean(NTRef.LifterLimitSwitch_Switched, ReferenceData.getInstance().getLifterLimitSwitchData().getIsSwitched());
 	}

 	private void shooterData()
 	{
 		IRSTable.putNumber(NTRef.Shooter_SetPoint, ReferenceData.getInstance().getShooterData().getMotorSetPoint());
 		IRSTable.putNumber(NTRef.Shooter_AngularEncoderSpeed, ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity());
 		IRSTable.putNumber(NTRef.Shooter_motor, ReferenceData.getInstance().getShooterData().getMotorSpeed());
 		IRSTable.putBoolean(NTRef.Shooter_HasFrisbee, ReferenceData.getInstance().getShooterData().getHasFrisbees());
 		IRSTable.putBoolean(NTRef.Shooter_ShouldFire, ReferenceData.getInstance().getShooterData().getShouldFire());
 	}
}