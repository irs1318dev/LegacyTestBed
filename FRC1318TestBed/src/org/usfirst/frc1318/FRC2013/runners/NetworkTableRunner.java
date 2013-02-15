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
//		if(val++ % 10 == 0)
//		{
			driveTrainData();
			lifterData();
			lifterLimitSwitchData();
			shooterData();
			solenoidData();
			userInputData();
//		}
	}
	
	private void driveTrainData()
	{
		IRSTable.putNumber(NTRef.DriveTrain_RightEncoder, ReferenceData.getInstance().getDriveTrainData().getRightEncoder());
		IRSTable.putNumber(NTRef.DriveTrain_LeftEncoder, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder());
		IRSTable.putNumber(NTRef.DriveTrain_RightSetPoint, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint());
		IRSTable.putNumber(NTRef.DriveTrain_RightPIDSpeed, ReferenceData.getInstance().getDriveTrainData().getRightPIDSpeed());
		IRSTable.putNumber(NTRef.DriveTrain_LeftPIDSpeed, ReferenceData.getInstance().getDriveTrainData().getLeftPIDSpeed());
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
 	
 	private void solenoidData()
 	{
 		IRSTable.putBoolean(NTRef.Solenoid_ShouldShooterBeUp, ReferenceData.getInstance().getSolenoidData().getShouldShooterBeUp());
 		IRSTable.putBoolean(NTRef.Solenoid_ShouldLifterBeUp, ReferenceData.getInstance().getSolenoidData().getShouldLifterBeUp());
 		IRSTable.putBoolean(NTRef.Solenoid_ShouldFrisbeeBeExtended, ReferenceData.getInstance().getSolenoidData().getShouldFrisbeeBeExtended());
 		IRSTable.putBoolean(NTRef.Solenoid_ShooterUp, ReferenceData.getInstance().getSolenoidData().getShooterUp());
 		IRSTable.putBoolean(NTRef.Solenoid_LifterUp, ReferenceData.getInstance().getSolenoidData().getLifterUp());
 		IRSTable.putBoolean(NTRef.Solenoid_FrisbeeExtended, ReferenceData.getInstance().getSolenoidData().getFrisbeeExtended());
 	}
 	
 	private void userInputData()
 	{
 		IRSTable.putNumber(NTRef.Input_LeftJoystick, ReferenceData.getInstance().getUserInputData().getJoystickLeft());
 		IRSTable.putNumber(NTRef.Input_RightJoystick, ReferenceData.getInstance().getUserInputData().getJoystickRight());
 		IRSTable.putNumber(NTRef.Input_JoystickX, ReferenceData.getInstance().getUserInputData().getJoystickX());
 		IRSTable.putNumber(NTRef.Input_JoystickY, ReferenceData.getInstance().getUserInputData().getJoystickY());
 		IRSTable.putBoolean(NTRef.Input_LiftDown, ReferenceData.getInstance().getUserInputData().getLiftDown());
 		IRSTable.putBoolean(NTRef.Input_LiftUp, ReferenceData.getInstance().getUserInputData().getLiftUp());
 		IRSTable.putBoolean(NTRef.Input_ShooterDown, ReferenceData.getInstance().getUserInputData().getShooterDown());
 		IRSTable.putBoolean(NTRef.Input_ShooterUp, ReferenceData.getInstance().getUserInputData().getShooterUp());
 		IRSTable.putBoolean(NTRef.Input_ShooterSpeedDown, ReferenceData.getInstance().getUserInputData().getShooterSpeedDown());
 		IRSTable.putBoolean(NTRef.Input_ShooterSpeedUp, ReferenceData.getInstance().getUserInputData().getShooterSpeedUp());
 		IRSTable.putBoolean(NTRef.Input_ShooterFire, ReferenceData.getInstance().getUserInputData().getShooterFire());
 	}
}