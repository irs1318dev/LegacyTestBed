package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import edu.wpi.first.wpilibj.Solenoid;

public class ShooterAngleRunner extends RobotComponentBase{
	//this represents one double solenoid
	private Solenoid upSolenoid;
	private Solenoid downSolenoid;
	
	public void robotInit() {
		upSolenoid = new Solenoid(PortRef.SHOOTER_UP_SOLENOID);
		downSolenoid = new Solenoid(PortRef.SHOOTER_DOWN_SOLENOID);
	}//robotinit
	
	public void teleopPeriodic() {
		
		//set shooter to either up or down based on data class
		if(ReferenceData.getInstance().getShooterData().getShooterUp())
		{
			upSolenoid.set(true);
			downSolenoid.set(false);
		}else{
			upSolenoid.set(false);
			downSolenoid.set(true);
		}//if/else
		
	}//teleop
	
	
}
