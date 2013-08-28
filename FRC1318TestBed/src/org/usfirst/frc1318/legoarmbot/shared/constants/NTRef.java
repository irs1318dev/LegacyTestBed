package org.usfirst.frc1318.legoarmbot.shared.constants;

public interface NTRef
{
	//Arm===================================================================
	String Arm_Theta1Encoder = "dt.1e";
	String Arm_Theta2Encoder = "dt.2e";
	String Arm_Theta1SetPoint = "dt.1sp";
	String Arm_Theta2SetPoint = "dt.2sp";
	String Arm_Theta1PIDSpeed = "dt.1ps";
	String Arm_Theta2PIDSpeed = "dt.2ps";
	//UserInput====================================================================
	String Input_LeftJoystickX = "i.ljs";
	String Input_RightJoystickX = "i.rjs";
	String Input_LeftJoystickY = "i.jx";
	String Input_RightJoystickY = "i.jy";
	String Input_LiftDown = "i.ld";
	String Input_LiftUp = "i.lu";
	String Input_ShooterDown = "i.sd";
	String Input_ShooterUp = "i.su";
	String Input_ShooterSpeedUp = "i.ssu";
	String Input_ShooterSpeedDown = "i.ssd";
	String Input_ShooterFire = "i.sf";
	//RobotGeneral=================================================================
	String Robot_State = "r.s";
	//=============================================================================
	String Input_JoystickMode = null;
}