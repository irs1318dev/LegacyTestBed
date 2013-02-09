package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import edu.wpi.first.wpilibj.DigitalInput;

public class LifterLimitSwitchReader extends RobotComponentBase{
	DigitalInput lifterLimitSwitch;
	
	public void robotInit() {
		lifterLimitSwitch = new DigitalInput(PortRef.SIDECAR_PORT, PortRef.LIFTER_LIMIT_SWITCH_PORT);
	}
	
	public void teleopPeriodic() {
		ReferenceData.getInstance().getLifterLimitSwitchData().setIsSwitched(lifterLimitSwitch.get());
	}
}
