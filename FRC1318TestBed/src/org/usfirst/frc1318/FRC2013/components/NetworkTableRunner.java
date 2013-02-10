package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.reference.NTReff;
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
			gamePadData();
			limitSwitchData();
			shooterData();
		}
	}
	
 	private void gamePadData()
	{
 		IRSTable.putNumber(NTReff.GamePad_LeftStickY, ReferenceData.getInstance().getJoystickData().getJoystickLY());
	}

 	private void limitSwitchData()
 	{
 		
 	}

 	private void shooterData()
 	{
 		IRSTable.putNumber(NTReff.Shooter_motor, ReferenceData.getInstance().getShooterData().getMotorSpeed());
 	}
}