package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.*;

public class AutonomousCenter extends AutonomousMode implements AutoTask{
	
	private static final double SHOOTER_SPEED = -0.810;
	private static final double DRIVE_FORWARD_TICKS = 400;
	private static final double BACK_UP_TICKS = -1700;
	private static final double TURN_AROUND_TICKS = 100;

	public void run() {
		System.out.println("*******************************************AutoFireAll currentState: " + currentState);
//		System.out.println("***********DriveTrain ticks: " + driveEncTicks);
		switch(currentState){
			case 0:
				driveForward(DRIVE_FORWARD_TICKS);
				break;
			case 1:
				andWait(1000);
				break;
			case 2:
				bothUp();
				break;
			case 3://spin up shooter
				spinShooter(SHOOTER_SPEED);
				break;
			case 4:
				andWait(500);
				break;
			case 5://fire
				fire();
				break;
			case 6://retract
				bothDown();
				break;
			case 7:
				andWait(1000);
				break;
			case 8: 
//				backUp();
				driveBackward(BACK_UP_TICKS);
				break;
			case 9:
//				spin();
				rotateRight(TURN_AROUND_TICKS);
				break;
			default:
				hasFinished = true;
				break;
		}
		
	}

	public void fire(){
		if(discsFired<3){
			if(System.currentTimeMillis() - startTime > 1000 && System.currentTimeMillis() - startTime < 1250) {
				System.out.println("*******Firing");
				ReferenceData.getInstance().getUserInputData().setShooterFire(true);
			} else if (System.currentTimeMillis() - startTime > 1250) {
				System.out.println("*******Waiting for next fire");
				startTime = System.currentTimeMillis();
				discsFired++;
			}
		}
		else{
			nextState();
		}
	}
	
	public void cancel() {
		ReferenceData.getInstance().getUserInputData().setShooterFire(false);
	}
}
