package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.autonomous.AutoTask;
import org.usfirst.frc1318.autonomous.AutonomousMode;

public class AutoSpinToAimMacro extends AutonomousMode implements AutoTask{
	
	private final int BACKWARD_DISTANCE = 100;
	private final int SPIN_DISTANCE = 100;
	
	public void run() {
		System.out.println("*******************************************AutoSpinToAim currentState: " + currentState);
		switch(currentState){
			case 0:
				driveBackward(BACKWARD_DISTANCE);
				break;
			case 1:
				rotateLeft(SPIN_DISTANCE);
				break;
			case 2:
				shooterUp();
				break;
			default:
				hasFinished = true;
				break;
		}
	}

	public void cancel() {
		
	}

}
