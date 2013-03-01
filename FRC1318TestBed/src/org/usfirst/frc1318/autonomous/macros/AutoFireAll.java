package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoFireAll implements AutoTask{

	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	
	private int currentState;
	private int  discsFired;
	private long startTime;
	private int count = 0;
	
	public void init() {
		discsFired = 0;
		count = 0;
		hasInitialized = true;
		System.out.println("*******************************************AutoFireAll init");
		startTime = System.currentTimeMillis();
	}

	public void run() {
		System.out.println("*******************************************AutoFireAll currentState: " + currentState);
		switch(currentState){
			case 0:
				andWait(3500);
				break;
			case 1:
				liftUp();
				break;
			case 2://spin up shooter
				spinShooter();
				break;
			case 3:
				andWait(1000);
				break;
			case 4://fire
				fire();
				break;
			case 5://retract
				bothDown();
				break;
			case 6:
				andWait(1000);
				break;
			case 7: 
				backUp();
				break;
			case 8:
				spin();
				break;
			default:
				hasFinished = true;
				break;
		}
		
	}
	public void liftUp(){
		ReferenceData.getInstance().getUserInputData().setBothUp(true);
		nextState();
	}
	
	public void spinShooter() {
		if(ReferenceData.getInstance().getShooterData().getMotorSetPoint() > -0.85){
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

	
	public void backUp(){
		if((System.currentTimeMillis() - startTime) < 1000){
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0.8);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		}else{
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	public void spin() {
		if((System.currentTimeMillis() - startTime) < 1700){
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
