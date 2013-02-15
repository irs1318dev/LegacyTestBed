package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Compressor;

public class CompressorRunner extends RobotComponentBase {
	private Compressor compressor;
	
	public void robotInit() {
		compressor = new Compressor(PortRef.SIDECAR_SLOT, PortRef.AIR_PRESSURE_SWITCH_CHANNEL, PortRef.DIGITAL_IO, PortRef.AIR_RELAY_CHANNEL);
		compressor.start();
	}
}
