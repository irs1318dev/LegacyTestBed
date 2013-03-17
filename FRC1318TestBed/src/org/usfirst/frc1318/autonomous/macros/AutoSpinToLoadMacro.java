package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.autonomous.AutoTask;
import org.usfirst.frc1318.autonomous.AutonomousMode;

public class AutoSpinToLoadMacro extends AutonomousMode implements AutoTask{

	private final int SPIN_DISTANCE = 100;
	private final int FORWARD_DISTANCE = 100;
	
	public void run() {
		System.out.println("*******************************************AutoSpinToLoad currentState: " + currentState);
		switch(currentState){
			case 0:
				rotateRight(SPIN_DISTANCE);
				break;
			case 1:
				driveForward(FORWARD_DISTANCE);
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
