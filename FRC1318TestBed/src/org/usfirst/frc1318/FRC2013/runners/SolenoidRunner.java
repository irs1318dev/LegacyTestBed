package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class SolenoidRunner extends RobotComponentBase
{
	DoubleSolenoid fireSolenoid, lifterSolenoid, shooterSolenoid;
	
	public void robotInit()
	{
		fireSolenoid = new DoubleSolenoid(PortRef.SHOOTER_FIRE_EXTEND, PortRef.SHOOTER_FIRE_RETRACT);
		lifterSolenoid = new DoubleSolenoid(PortRef.LIFTER_EXTENDER_SOLENOID_PORT, PortRef.LIFTER_RETRACTOR_SOLENOID_PORT);
		shooterSolenoid = new DoubleSolenoid(PortRef.SHOOTER_UP_SOLENOID, PortRef.SHOOTER_DOWN_SOLENOID);
	}
	
	public void teleopPeriodic()
	{
		if(ReferenceData.getInstance().getSolenoidData().getShouldShooterBeUp() && 
				!ReferenceData.getInstance().getSolenoidData().getShooterUp())
		{
			shooterSolenoid.set(Value.kReverse);
			ReferenceData.getInstance().getSolenoidData().setShooterUp(true);
		}
		else if(!ReferenceData.getInstance().getSolenoidData().getShouldShooterBeUp() && 
				ReferenceData.getInstance().getSolenoidData().getShooterUp())
		{
			shooterSolenoid.set(Value.kForward);
			ReferenceData.getInstance().getSolenoidData().setShooterUp(false);
		}
		if(ReferenceData.getInstance().getSolenoidData().getShouldLifterBeUp() && 
				!ReferenceData.getInstance().getSolenoidData().getLifterUp())
		{
			lifterSolenoid.set(Value.kReverse);
			ReferenceData.getInstance().getSolenoidData().setLifterUp(true);
		}
		else if(!ReferenceData.getInstance().getSolenoidData().getShouldLifterBeUp() && 
				ReferenceData.getInstance().getSolenoidData().getLifterUp())
		{
			lifterSolenoid.set(Value.kForward);
			ReferenceData.getInstance().getSolenoidData().setLifterUp(false);
		}
		if(ReferenceData.getInstance().getSolenoidData().getShouldFrisbeeBeExtended() && 
				!ReferenceData.getInstance().getSolenoidData().getFrisbeeExtended())
		{
			fireSolenoid.set(Value.kForward);
			ReferenceData.getInstance().getSolenoidData().setFrisbeeExtended(true);
		}
		else if(!ReferenceData.getInstance().getSolenoidData().getShouldFrisbeeBeExtended() && 
				ReferenceData.getInstance().getSolenoidData().getFrisbeeExtended())
		{
			fireSolenoid.set(Value.kReverse);
			ReferenceData.getInstance().getSolenoidData().setFrisbeeExtended(false);
		}
	}
}
