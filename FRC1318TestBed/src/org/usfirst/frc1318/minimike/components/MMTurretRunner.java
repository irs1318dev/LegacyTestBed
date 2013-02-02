package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.shared.MMReferenceData;
import org.usfirst.frc1318.minimike.shared.constants.MMPortRef;

import edu.wpi.first.wpilibj.Victor;

public class MMTurretRunner extends RobotComponentBase {
	private Victor turret;
	
	public void robotInit() {
		
		//this should make a new Victor in percent mode
			turret = new Victor(MMPortRef.SIDECAR_PORT, MMPortRef.TURRET);
		
	}
	
	public void teleopPeriodic() {
		
		//This should set the speed of the motor controlled by the jaguar
			turret.set(MMReferenceData.getInstance().getMMTurretData().getTurnSpeed());
			//System.out.println("turret is moving" + MMTurretData.getInstance().getTurnSpeed());
			//System.out.println(MMTurretData.getTurnSpeed());
	}
}
