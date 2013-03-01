package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutonomousRight implements AutoTask {

	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	
	private int currentState;
	private int  discsFired;
	private long startTime;
	private int count = 0;


	public void init() {
		hasInitialized = true;
		discsFired = 0;
		System.out.println("*******************************************AutonomousRight init");
		startTime = System.currentTimeMillis();
	}

	public void run() {
		System.out.println("*******************************************AutotonomousRight currentState: " + currentState);
		switch(currentState){
			case 0:
				andWait(1000);
				break;
			case 1:
				driveToFront();
				break;
			case 2:
				faceGoal();
				break;
			case 3:
				bothUp();
				break;
			case 4:
				spinShooter();
				break;
			case 5:
				andWait(1000);
				break;
			case 6: 
				fire();
				break;
			case 7:
				bothDown();
				break;
			case 8:
				andWait(1000);
				break;
			case 9:
				turnAround();
				break;
			case 10:
				driveToCenterLine();
				break;
			default:
				hasFinished = true;
				break;
	
		}
	}
	
	public void bothUp(){
		ReferenceData.getInstance().getUserInputData().setBothUp(true);
		nextState();
	}
	
	public void spinShooter() {
		if(ReferenceData.getInstance().getShooterData().getMotorSetPoint() > -0.8){
			ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(true);
//			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}else{
			nextState();
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
	
	public void bothDown(){
		ReferenceData.getInstance().getUserInputData().setBothDown(true);
		nextState();
	}
	
	public void andWait(long delay){
//		System.out.println("*******************CurrentTimeIs:"+(System.currentTimeMillis()-startTime));
		if((System.currentTimeMillis() - startTime) >= delay){
			nextState();	
		}
	}
	
	
	public void driveToFront(){
		if((System.currentTimeMillis() - startTime) < 1250){
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
	
	public void nextState() {
		currentState++;
		count = 0;
		startTime = System.currentTimeMillis();
	}
	
	public void cancel() {
		ReferenceData.getInstance().getUserInputData().setShooterFire(false);
	}

	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInitialized;
	}

}
