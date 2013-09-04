package org.usfirst.frc1318.simpleRIAB;

import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Talon;

public class TalonRunner extends RobotComponentBase{
	
	Talon talon;
	
	public void robotInit(){
		talon = new Talon(PortRef.SIDECAR_SLOT, PortRef.TALON);
	}
	
	public void teleopPeriodic(){
		double val = GamePadData.getInstance().getYValue();
		val = Math.min(val, 1);
		val = Math.max(val, -1);
		talon.set(val);
	}

}
