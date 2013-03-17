package org.usfirst.frc1318.autonomous;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

public abstract class AutonomousMode implements AutoTask {

	protected boolean hasFinished = false;
	protected boolean hasInitialized = false;
	
	protected int currentState;
	protected int  discsFired;
	protected long startTime;
	protected double driveEncTicks = 0;		// left side used to track drive train ticks
	
	private boolean buttonDown = false;
	
	public void init() {
		currentState = 0;
		discsFired = 0;
		startTime = System.currentTimeMillis();
		driveEncTicks = ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
		ReferenceData.getInstance().getSolenoidData().setShouldWeRunSolenoids(true);
		hasInitialized = true;
	}

	public abstract void run();

	public abstract void cancel();

	// Raise both the lifter arm and the shooter tray
	public void bothUp(){
		ReferenceData.getInstance().getUserInputData().setBothUp(true);
		nextState();
	}
	
	public void shooterUp(){
		ReferenceData.getInstance().getUserInputData().setShooterUp(true);
	}
	
	
	// Lower both the lifter arm and the shooter tray
	public void bothDown(){
		ReferenceData.getInstance().getUserInputData().setBothDown(true);
		nextState();
	}

	// Do nothing for the given number of milliseconds
	public void andWait(long delay){
//		System.out.println("Been waiting " + (System.currentTimeMillis() - startTime) + " of " + delay);
		if((System.currentTimeMillis() - startTime) >= delay){
			nextState();	
		}
	}
	
	// Spin the shooter wheel up to the given speed
	public void spinShooter(double speed) {
		if (buttonDown && ReferenceData.getInstance().getShooterData().getMotorSetPoint() > speed) { 
			ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(false);
			buttonDown = false;
		} else if(ReferenceData.getInstance().getShooterData().getMotorSetPoint() > speed){
			ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(true);
			buttonDown = true;
		}else{
			nextState();
		}
	}
	
	// Drive forward the given number of ticks
	public void driveForward(double encTicks) {
//		ReferenceData.getInstance().getUserInputData().setJoystickX(-0.3);
//		if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoder() < ReferenceData.getInstance().getDriveTrainData().getRightEncoder()	) {
//			ReferenceData.getInstance().getUserInputData().setJoystickY(ReferenceData.getInstance().getUserInputData().getJoystickY() + .01);
//		} else if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoder() > ReferenceData.getInstance().getDriveTrainData().getRightEncoder()	) {
//			ReferenceData.getInstance().getUserInputData().setJoystickY(ReferenceData.getInstance().getUserInputData().getJoystickY() - .01);
//		}
		System.out.println("*********Driven " + (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks) + " of " + encTicks);
		if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks > encTicks) {
			ReferenceData.getInstance().getUserInputData().setJoystickX(-0.2);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0.01);			
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	// Drive backward the given number of ticks
	public void driveBackward(double encTicks) {
//		ReferenceData.getInstance().getUserInputData().setJoystickX(0.3);
//		if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoder() < ReferenceData.getInstance().getDriveTrainData().getRightEncoder()	) {
//			ReferenceData.getInstance().getUserInputData().setJoystickY(ReferenceData.getInstance().getUserInputData().getJoystickY() + .01);
//		} else if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoder() > ReferenceData.getInstance().getDriveTrainData().getRightEncoder()	) {
//			ReferenceData.getInstance().getUserInputData().setJoystickY(ReferenceData.getInstance().getUserInputData().getJoystickY() - .01);
//		}
				if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks < encTicks) {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0.2);
			ReferenceData.getInstance().getUserInputData().setJoystickY(-.01);			
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	// Rotate left (counter-clockwise) the given number of ticks
	public void rotateLeft(double encTicks) {
		System.out.println("Moved " + (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks) + " of " + encTicks);
		if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks < encTicks) {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(1.0);			
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}
	
	// Rotate right (clockwise) the given number of ticks
	public void rotateRight(double encTicks) {
		System.out.println("Moved " + (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks) + " of " + encTicks);
		if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() - driveEncTicks > encTicks) {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(-1.0);			
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickX(0);
			ReferenceData.getInstance().getUserInputData().setJoystickY(0);
			nextState();
		}
	}

	// Advance the macro to the next state
	public void nextState() {
		currentState++;
		driveEncTicks = ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
		startTime = System.currentTimeMillis();
	}
	
	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInitialized;
	}
}
