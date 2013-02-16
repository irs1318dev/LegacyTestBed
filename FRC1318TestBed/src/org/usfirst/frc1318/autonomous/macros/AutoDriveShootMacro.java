package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.reference.StateRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

import edu.wpi.first.wpilibj.Timer;


public class AutoDriveShootMacro implements AutoTask {
	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	private boolean newState = true;
	
	private int currentState = StateRef.AUTO_DRIVE_SHOOT_MACRO_DEFAULT;
	
	private double stateStartTime;
	private double initWaitTime = 3000000;//3 seconds
	private double waitForPistonsTime = 500000;//.5 seconds TODO
	private double ticksToShootPosition = 0;//TODO
	private double driveForwardSpeed = .3;//TODO
	private double driveBackSlowlySpeed = -.1;//TODO
	private double stop = 0;
	private double tooFar = ticksToShootPosition + 1000;//TODO
	private double shooterMotorSetPoint = .75;//TODO
	private double shooterMinSpeed = 0;//TODO
	private double shooterMaxSpeed = 0;//TODO
	
	private Timer timer;
	
	public void init() {
		timer = new Timer();
		timer.start();
		hasInitialized = true;
	}

	public void run() {
		switch(currentState) {
		case StateRef.INITIALIZE:
			initialize();
			break;
		case StateRef.PREPRARE_TO_DRIVE_UNDER_PYRAMID:
			prepareToDriveUnderPyramid();
			break;
		case StateRef.DRIVE_TO_LAUNCH_POSITION:
			driveToLaunchPosition();
			break;
		case StateRef.PREPARE_TO_SHOOT:
			prepareToShoot();
			break;
		case StateRef.FIRE:
			fire();
			break;
		case StateRef.PREPARE_TO_DRIVE:
			prepareToDrive();
			break;
		case StateRef.BACK_UP:
			backUp();
			break;
		case StateRef.ROTATE:
			rotate();
			break;
		default:
			break;
		}
		hasFinished = true;
	}

	public void cancel() {
		
	}
	
	public boolean hasFinished() {
		return hasFinished;
	}

	public boolean hasInitalized() {
		return hasInitialized;
	}
	
	private void initialize() {
		if(newState) {
			stateStartTime = timer.get();
			newState = false;
		}
		if(timer.get() - stateStartTime >= initWaitTime) {
			currentState = StateRef.PREPRARE_TO_DRIVE_UNDER_PYRAMID;
			newState = true;
		}
	}
	
	private void prepareToDriveUnderPyramid() {
		if(newState) {
			ReferenceData.getInstance().getUserInputData().setShooterDown(true);
			ReferenceData.getInstance().getUserInputData().setLiftUp(true);
			stateStartTime = timer.get();
			newState = false;
		}
		if(timer.get() - stateStartTime >= waitForPistonsTime) {
			currentState = StateRef.DRIVE_TO_LAUNCH_POSITION;
			newState = true;
		}
	}
	
	private void driveToLaunchPosition() {
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(shooterMotorSetPoint);
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 <= ticksToShootPosition) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveForwardSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveForwardSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveForwardSpeed);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 >= tooFar) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveBackSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveBackSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveBackSlowlySpeed);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickY(stop);
			currentState = StateRef.PREPARE_TO_SHOOT;
		}
	}
	
	private void prepareToShoot() {
		if(newState) {
			ReferenceData.getInstance().getUserInputData().setShooterUp(true);
			stateStartTime = timer.get();
			newState = false;
		}
		if(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() >= shooterMinSpeed 
			&& ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() <= shooterMaxSpeed 
			&& timer.get() - stateStartTime >=waitForPistonsTime) {
				currentState = StateRef.FIRE;
				newState = true;
		}
	}
	
	private void fire() {
		
	}
	
	private void prepareToDrive() {
		
	}
	
	private void backUp() {
		
	}
	
	private void rotate() {
		
	}
}
