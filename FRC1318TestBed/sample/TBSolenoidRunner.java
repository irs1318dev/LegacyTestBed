package org.usfirst.frc1318.runners;

import org.usfirst.frc1318.runners.components.TBSolenoidData;
import org.usfirst.frc1318.shared.constants.TBPortRef;

import edu.wpi.first.wpilibj.Solenoid;

public class TBSolenoidRunner extends Runner{
	
	final int PORT = TBPortRef.SOLENIOD_RUNNER;
	
	private Solenoid kicker = null;
	
	public void robotInit() {
		kicker = new Solenoid(PORT);
	}
	
	public void teleopPeriodic() {
		boolean extended = TBSolenoidData.kicked();
		kicker.set(extended);
	}
	
}
