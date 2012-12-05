package org.usfirst.frc1318.runners.components;

import org.usfirst.frc1318.reference.TBThroughBeamData;
import org.usfirst.frc1318.runners.Runner;
import org.usfirst.frc1318.shared.constants.TBPortRef;
import edu.wpi.first.wpilibj.DigitalInput;

public class TBThroughBeamReader extends Runner{
	
	final int PORT = TBPortRef.THROUGH_BEAM_SENSOR;
	
	DigitalInput input = null;
	
	public void robotInit(){
		input = new DigitalInput(PORT);
	}
	
	public void teleopPeriodic(){
		boolean broken = input.get();
		//broken = false 
		TBThroughBeamData.set(broken);
	}

}
