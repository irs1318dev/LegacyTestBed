package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.reference.PortRef;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class LifterRunner extends RobotComponentBase{
	private DoubleSolenoid lifterSolenoid;
	
	public void robotInit() {
		lifterSolenoid = new DoubleSolenoid(PortRef.SOLENOID_MODULE_PORT, PortRef.LIFTER_EXTENDER_SOLENOID_PORT, PortRef.LIFTER_RETRACTOR_SOLENOID_PORT);
	}
	
	public void teleopPeriodic() {
		if (ReferenceData.getInstance().getLifterData().getShouldLift()) {
			lifterSolenoid.set(Value.kForward);
		} else {
			lifterSolenoid.set(Value.kReverse);
		}
		
	}
}
