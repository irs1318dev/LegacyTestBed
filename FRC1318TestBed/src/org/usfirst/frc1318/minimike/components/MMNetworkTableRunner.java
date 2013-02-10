package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.reference.NTRef;
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
		IRSTable.putBoolean(NTRef.Gamepad_AtonButton, MMReferenceData.getInstance().getMMGamePadData().getAutonomousButton());
		IRSTable.putBoolean(NTRef.Gamepad_LeftButton, MMReferenceData.getInstance().getMMGamePadData().getLeftButton());
		IRSTable.putBoolean(NTRef.Gamepad_RightButton, MMReferenceData.getInstance().getMMGamePadData().getRightButton());
	}

 	private void limitSwitchData()
 	{
 		IRSTable.putBoolean(NTRef.LimitSwitch_LeftSwitch, MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState());
 		IRSTable.putBoolean(NTRef.LimitSwitch_RightSwitch, MMReferenceData.getInstance().getMMLimitSwitchData().getRightState());
 	}

 	private void turretData()
 	{
 		IRSTable.putNumber(NTRef.Turret_TurnSpeed, MMReferenceData.getInstance().getMMTurretData().getTurnSpeed());
 	}
}