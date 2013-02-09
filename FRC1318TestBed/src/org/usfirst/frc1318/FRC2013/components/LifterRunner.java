package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.reference.PortRef;

import edu.wpi.first.wpilibj.Solenoid;

public class LifterRunner extends RobotComponentBase{
	private Solenoid lifterExtenderSolenoid;
	private Solenoid lifterRetractorSolenoid;
	
	public void robotInit() {
		lifterExtenderSolenoid = new Solenoid(PortRef.SOLENOID_MODULE_PORT, PortRef.LIFTER_EXTENDER_SOLENOID_PORT);
		lifterRetractorSolenoid = new Solenoid(PortRef.SOLENOID_MODULE_PORT, PortRef.LIFTER_RETRACTOR_SOLENOID_PORT);
	}
	
	public void teleopPeriodic() {
		lifterExtenderSolenoid.set(ReferenceData.getInstance().getLifterData().getShouldLift());
		lifterRetractorSolenoid.set(!ReferenceData.getInstance().getLifterData().getShouldLift());
	}
}
