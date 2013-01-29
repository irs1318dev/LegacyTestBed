package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.shared.MMTurretData;
import org.usfirst.frc1318.minimike.shared.constants.MMPortRef;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

public class MMTurretRunner extends RobotComponentBase {
	private CANJaguar turret;
	
	public void robotInit() {
		
		//this should make a new jaguar in percent mode
		try {
			turret = new CANJaguar(MMPortRef.TURRET, 
					CANJaguar.ControlMode.kPercentVbus);
		} catch (CANTimeoutException e) {
			e.printStackTrace();
		}
		
	}
	
	public void teleopPeriodic() {
		
		//This should set the speed of the motor controlled by the jaguar
		try {
			turret.setX(MMTurretData.getTurnSpeed());
		} catch (CANTimeoutException e) {
			e.printStackTrace();
		}
	}
}
