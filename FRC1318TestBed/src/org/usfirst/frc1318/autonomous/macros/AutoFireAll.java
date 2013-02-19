package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

public class AutoFireAll implements AutoTask{

	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	private boolean newState = true;
	
	private int currentState;
	private int  discsFired;
	
	public void init() {
		discsFired = 0;
		hasInitialized = true;
		System.out.println("AutoFireAll init");
	}

	public void run() {
		System.out.println("AutoFireAll currentState: " + currentState);
		switch(currentState){
			case 0://retract
				break;
			case 1://fire
				break;//retract
			default:
				hasFinished = true;
				break;
		}
		
	}

	public void retract(){
		if(ReferenceData.getInstance().getShooterData().getShouldFire())
			currentState++;		
	}
	
	public void extend(){
		if(discsFired<4){
			ReferenceData.getInstance().getUserInputData().setShooterFire(true);
			currentState = 0;
			discsFired++;
		}
		else{
			currentState++;
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
