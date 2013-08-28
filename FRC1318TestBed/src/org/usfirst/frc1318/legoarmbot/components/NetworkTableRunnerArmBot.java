package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.legoarmbot.shared.constants.NTRef;
import org.usfirst.frc1318.legoarmbot.shared.ReferenceData;
import org.usfirst.frc1318.generic.networktable.IRSTable;


public class NetworkTableRunnerArmBot extends RobotComponentBase
{
	int val = 0;
	public void robotInit()
	{
		System.out.println("Network Table is ready!");
		IRSTable.putString(NTRef.Robot_State, "Init");
	}
	
	public void teleopInit()
	{
		IRSTable.putString(NTRef.Robot_State, "Teleop");
	}
	
	public void disabledInit()
	{
		IRSTable.putString(NTRef.Robot_State, "Disabled");
	}
	
	public void teleopPeriodic() 
	{
		if(val++ % 10 == 0)
		{
			armData();
			userInputData();
		}
	}
	
	private void armData()
	{
		IRSTable.putNumber(NTRef.Arm_Theta1Encoder, ReferenceData.getInstance().getArmData().getTheta1Encoder());
		IRSTable.putNumber(NTRef.Arm_Theta2Encoder, ReferenceData.getInstance().getArmData().getTheta2Encoder());
		IRSTable.putNumber(NTRef.Arm_Theta1SetPoint, ReferenceData.getInstance().getArmData().getTheta1PositionSetPoint());
		IRSTable.putNumber(NTRef.Arm_Theta2SetPoint, ReferenceData.getInstance().getArmData().getTheta2PositionSetPoint());
		IRSTable.putNumber(NTRef.Arm_Theta1PIDSpeed, ReferenceData.getInstance().getArmData().getTheta1PIDSpeed());
		IRSTable.putNumber(NTRef.Arm_Theta2PIDSpeed, ReferenceData.getInstance().getArmData().getTheta2PIDSpeed());
	}
 	
 	private void userInputData()
 	{
 		IRSTable.putNumber(NTRef.Input_RightJoystickX, ReferenceData.getInstance().getUserInputData().getDeltaX());
 		IRSTable.putNumber(NTRef.Input_RightJoystickY, ReferenceData.getInstance().getUserInputData().getDeltaY());
 		IRSTable.putNumber(NTRef.Input_LeftJoystickX, ReferenceData.getInstance().getUserInputData().getClosedFormX());
 		IRSTable.putNumber(NTRef.Input_LeftJoystickY, ReferenceData.getInstance().getUserInputData().getClosedFormY());
 		IRSTable.putBoolean(NTRef.Input_JoystickMode, ReferenceData.getInstance().getUserInputData().isRightJoyStickActive());
 	}
}