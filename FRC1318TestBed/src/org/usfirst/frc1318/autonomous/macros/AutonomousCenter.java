package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.*;

public class AutonomousCenter extends AutonomousMode implements AutoTask{
	
	private static final double SHOOTER_SPEED = -0.750;
	private static final double DRIVE_FORWARD_TICKS = -400;
	private static final double BACK_UP_TICKS = 0;
	private static final double TURN_AROUND_TICKS = -250;

	public void run() {
		System.out.println("*******************************************AutoFireAll currentState: " + currentState);
//		System.out.println("***********DriveTrain ticks: " + driveEncTicks); 
		switch(currentState){
			case 0:
				driveForward(DRIVE_FORWARD_TICKS);
				System.out.println("*******************" + currentState + "__" + DRIVE_FORWARD_TICKS);
				break;
			case 1:
				andWait(3500);
				System.out.println("*******************1");
				break;
			case 2:
				bothUp();
				System.out.println("*******************2");
				break;
			case 3://spin up shooter
				spinShooter(SHOOTER_SPEED);
				System.out.println("*******************3");
				break;
			case 4:
				andWait(500);
				System.out.println("*******************4");
				break;
			case 5://fire
				fire();
				System.out.println("*******************5");
				break;
			case 6://retract
				bothDown();
				System.out.println("*******************6");
				break;
			case 7:
				andWait(500);
				System.out.println("*******************7");
				break;
//			case 8: 
////				backUp();
//				driveBackward(BACK_UP_TICKS);
//				System.out.println("*******************8");
//				break;
//			case 9:
//				andWait(250);
//				System.out.println("*******************7");
//				break;
//			case 10:
////				spin();
//				rotateRight(TURN_AROUND_TICKS);
//				System.out.println("*******************9");
//				break;
			default:
				hasFinished = true;
				break;
		}
		
	}

	public void fire(){
		if(discsFired<3){
			if(System.currentTimeMillis() - startTime > 1500 && System.currentTimeMillis() - startTime < 1750) {
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
