package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.networktable.IRSNetTable;//as of now, this is just a shortcut
import org.usfirst.frc1318.minimike.networktable.NTReff;
import org.usfirst.frc1318.minimike.shared.MMGamePadData;
import org.usfirst.frc1318.minimike.shared.MMLimitSwitchData;
import org.usfirst.frc1318.minimike.shared.MMTurretData;


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
		IRSNetTable.putBoolean(NTReff.Gamepad_AtonButton, MMGamePadData.getInstance().getAutonomousButton());
		IRSNetTable.putBoolean(NTReff.Gamepad_LeftButton, MMGamePadData.getInstance().getLeftButton());
		IRSNetTable.putBoolean(NTReff.Gamepad_RightButton, MMGamePadData.getInstance().getRightButton());
	}

 	private void limitSwitchData()
 	{
 		IRSNetTable.putBoolean(NTReff.LimitSwitch_LeftSwitch, MMLimitSwitchData.getInstance().getLeftState());
 		IRSNetTable.putBoolean(NTReff.LimitSwitch_RightSwitch, MMLimitSwitchData.getInstance().getRightState());
 	}

 	private void turretData()
 	{
 		IRSNetTable.putDouble(NTReff.Turret_TurnSpeed, MMTurretData.getInstance().getTurnSpeed());
 	}
}