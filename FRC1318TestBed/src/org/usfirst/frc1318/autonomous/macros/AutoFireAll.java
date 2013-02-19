package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.reference.StateRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoFireAll implements AutoTask{

	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	private boolean newState = true;
	
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
				startUp();
				break;
			case 1://wait
				andWait();
				break;
			case 2://fire
				fire();
				break;//retract
			case 3:
				bothDown();
				break;
			case 4: 
				spinBackward();
				break;
			default:
				hasFinished = true;
				break;
		}
		
	}
	public void startUp(){
		if(count == 0){
			ReferenceData.getInstance().getUserInputData().setBothUp(true);
			startTime = System.currentTimeMillis();
		}else if(System.currentTimeMillis() - startTime < 2500){
			ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(true);
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		}else{
			currentState++;
			count = 0;
		}
		count++;
	}
	
	public void andWait(){
		System.out.println("*******************CurrentTimeIs:"+(System.currentTimeMillis()-startTime));
		if((System.currentTimeMillis() - startTime) >= 2500){
			currentState++;	
		}
			
	}
	
	public void fire(){
		if(discsFired<4){
			if(count<15){
				ReferenceData.getInstance().getUserInputData().setShooterFire(true);
				count++;
			} else{
				count = 0;
				currentState = 1;
				discsFired++;
				startTime = System.currentTimeMillis();
			}
		}
		else{
			currentState++;
		}
	}
	
	public void bothDown(){
		ReferenceData.getInstance().getUserInputData().setBothDown(true);
		startTime = System.currentTimeMillis();
		currentState++;
	}
	
	public void spinBackward(){
		if((System.currentTimeMillis() - startTime) < 500){
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
			ReferenceData.getInstance().getUserInputData().setJoystickX(1);
			ReferenceData.getInstance().getUserInputData().setJoystickY(-1);
		}else{
			currentState++;
//			ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
//			ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		}
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
