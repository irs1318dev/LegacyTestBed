package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.networktable.NTReff;
import org.usfirst.frc1318.minimike.shared.MMReferenceData;
import org.usfirst.frc1318.generic.networktable.IRSTable;


public class MMNetworkTableRunner extends RobotComponentBase
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
			gamePadData();
			limitSwitchData();
			turretData();
		}
	}
	
 	private void gamePadData()
	{
		IRSTable.putBoolean(NTReff.Gamepad_AtonButton, MMReferenceData.getInstance().getMMGamePadData().getAutonomousButton());
		IRSTable.putBoolean(NTReff.Gamepad_LeftButton, MMReferenceData.getInstance().getMMGamePadData().getLeftButton());
		IRSTable.putBoolean(NTReff.Gamepad_RightButton, MMReferenceData.getInstance().getMMGamePadData().getRightButton());
	}

 	private void limitSwitchData()
 	{
 		IRSTable.putBoolean(NTReff.LimitSwitch_LeftSwitch, MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState());
 		IRSTable.putBoolean(NTReff.LimitSwitch_RightSwitch, MMReferenceData.getInstance().getMMLimitSwitchData().getRightState());
 	}

 	private void turretData()
 	{
 		IRSTable.putNumber(NTReff.Turret_TurnSpeed, MMReferenceData.getInstance().getMMTurretData().getTurnSpeed());
 	}
}