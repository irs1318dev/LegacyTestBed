package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

public class SolenoidCalculator extends RobotComponentBase
{
	public void robotInit() 
	{
		
	}

	public void disabledInit() 
	{
		
	}

	public void autonomousInit() 
	{
		ReferenceData.getInstance().getSolenoidData().setShouldFrisbeeBeExtended(false);
		ReferenceData.getInstance().getSolenoidData().setShouldLifterBeUp(false);
		ReferenceData.getInstance().getSolenoidData().setShouldShooterBeUp(false);
		ReferenceData.getInstance().getSolenoidData().setFrisbeeExtended(true);
		ReferenceData.getInstance().getSolenoidData().setLifterUp(true);
		ReferenceData.getInstance().getSolenoidData().setShooterUp(true);
	}

	public void teleopInit() 
	{
		ReferenceData.getInstance().getSolenoidData().setShouldFrisbeeBeExtended(false);
		ReferenceData.getInstance().getSolenoidData().setShouldLifterBeUp(false);
		ReferenceData.getInstance().getSolenoidData().setShouldShooterBeUp(false);
		ReferenceData.getInstance().getSolenoidData().setFrisbeeExtended(true);
		ReferenceData.getInstance().getSolenoidData().setLifterUp(true);
		ReferenceData.getInstance().getSolenoidData().setShooterUp(true);
	}

	public void disabledPeriodic() 
	{
		
	}

	public void autonomousPeriodic() 
	{
		teleopPeriodic();
	}

	public void teleopPeriodic() 
	{
		if(ReferenceData.getInstance().getUserInputData().getLiftDown())
		{
			ReferenceData.getInstance().getSolenoidData().setShouldLifterBeUp(false);
			ReferenceData.getInstance().getSolenoidData().setShouldShooterBeUp(false);
		}
		if(ReferenceData.getInstance().getUserInputData().getShooterUp())
		{
			ReferenceData.getInstance().getSolenoidData().setShouldLifterBeUp(true);
			ReferenceData.getInstance().getSolenoidData().setShouldShooterBeUp(true);
		}
		if(ReferenceData.getInstance().getUserInputData().getLiftUp())
		{
			ReferenceData.getInstance().getSolenoidData().setShouldLifterBeUp(true);
		}
		if(ReferenceData.getInstance().getUserInputData().getShooterDown())
		{
			ReferenceData.getInstance().getSolenoidData().setShouldShooterBeUp(false);
		}
		ReferenceData.getInstance().getSolenoidData().setShouldFrisbeeBeExtended(
				ReferenceData.getInstance().getUserInputData().getShooterFire()
				);
	}
}