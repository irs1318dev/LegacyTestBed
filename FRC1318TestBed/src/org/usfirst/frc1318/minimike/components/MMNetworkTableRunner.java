package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.networktable.IRSNetTable;//as of now, this is just a shortcut
import org.usfirst.frc1318.minimike.networktable.NTReff;
import org.usfirst.frc1318.minimike.shared.MMReferenceData;


public class MMNetworkTableRunner extends RobotComponentBase
{
	public void robotInit()
	{
		IRSNetTable.init();
	}
	
	public void teleopPeriodic() 
	{
		gamePadData();
		limitSwitchData();
		turretData();
	}
	
 	private void gamePadData()
	{
		IRSNetTable.putBoolean(NTReff.Gamepad_AtonButton, MMReferenceData.getInstance().getMMGamePadData().getAutonomousButton());
		IRSNetTable.putBoolean(NTReff.Gamepad_LeftButton, MMReferenceData.getInstance().getMMGamePadData().getLeftButton());
		IRSNetTable.putBoolean(NTReff.Gamepad_RightButton, MMReferenceData.getInstance().getMMGamePadData().getRightButton());
	}

 	private void limitSwitchData()
 	{
 		IRSNetTable.putBoolean(NTReff.LimitSwitch_LeftSwitch, MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState());
 		IRSNetTable.putBoolean(NTReff.LimitSwitch_RightSwitch, MMReferenceData.getInstance().getMMLimitSwitchData().getRightState());
 	}

 	private void turretData()
 	{
 		IRSNetTable.putDouble(NTReff.Turret_TurnSpeed, MMReferenceData.getInstance().getMMTurretData().getTurnSpeed());
 	}
}