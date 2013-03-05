package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.*;

public class AutonomousRight extends AutonomousMode implements AutoTask {

	private static final double SHOOTER_SPEED = -0.78;
	private static final double DRIVE_FORWARD_TICKS = 1300;
	private static final double FACE_GOAL_TICKS = -50;
	private static final double TURN_AROUND_TICKS = 50;
	private static final double TO_LINE_TICKS = -2700;
	
	
	public void run() {
		System.out.println("*******************************************AutotonomousRight currentState: " + currentState);
		switch(currentState){
			case 0:
				andWait(3500);
				break;
			case 1:
//				driveToFront();
				driveForward(DRIVE_FORWARD_TICKS);
				break;
			case 2:
				andWait(500);
				break;
			case 3:
//				faceGoal();
				rotateLeft(FACE_GOAL_TICKS);
				break;
			case 4:
				bothUp();
				break;
			case 5:
				spinShooter(SHOOTER_SPEED);
				break;
			case 6:
				andWait(500);
				break;
			case 7: 
				fire();
				break;
			case 8:
				bothDown();
				break;
			case 9:
				andWait(1000);
				break;
			case 10:
//				turnAround();
				rotateRight(TURN_AROUND_TICKS);
				break;
			case 11:
//				driveToCenterLine();
				driveBackward(TO_LINE_TICKS);
				break;
			default:
				hasFinished = true;
				break;
	
		}
	}
	
	public void fire(){
		if(discsFired<3){
			if(System.currentTimeMillis() - startTime > 750 && System.currentTimeMillis() - startTime < 1000) {
				System.out.println("*******Firing");
				ReferenceData.getInstance().getUserInputData().setShooterFire(true);
			} else if (System.currentTimeMillis() - startTime > 1000) {
				System.out.println("*******Waiting for next fire");
				startTime = System.currentTimeMillis();
				discsFired++;
			}
		}
		else{
			nextState();
		}
	}
	
	public void driveToFront(){
		if((System.currentTimeMillis() - startTime) < 1250){
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(-0.8);
			ReferenceData.getInstance().getUserInputData().setJoystickY(-0.2);
		}else{
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	public void driveToCenterLine(){
		if((System.currentTimeMillis() - startTime) < 2000){
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(-0.8);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		}else{
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	public void faceGoal() {
		if((System.currentTimeMillis() - startTime) < 300){
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0.8);
		}else{
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	public void turnAround() {
		if((System.currentTimeMillis() - startTime) < 1700){
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(-0.8);
		}else{
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	public void cancel() {
		ReferenceData.getInstance().getUserInputData().setShooterFire(false);
	}
}
