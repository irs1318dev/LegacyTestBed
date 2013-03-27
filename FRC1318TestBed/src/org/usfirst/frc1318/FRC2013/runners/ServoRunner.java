package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ServoData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.Servo;

/**
 * 
 * @author Graham
 * 
 * This class simply reads from the ServoData stored in ReferenceData and 
 * sets the servo to either up or down accordingly
 *
 */
public class ServoRunner extends RobotComponentBase{
	Servo servo;
	ServoData data;
	
	final double down = 1;	//TODO check values are correct
	final double up = 0;
	
	public void robotInit() {
		servo = new Servo(PortRef.SERVO);
		data = ReferenceData.getInstance().getServoData();
		
		servo.set(up);					
		data.setState(data.UP);
	}
	
	public void teleopPeroidic() {
		if(data.DOWN == data.getState()) {
			servo.set(down);
		}
		else if(data.UP == data.getState()) {
			servo.set(up);
		}
	}
}
