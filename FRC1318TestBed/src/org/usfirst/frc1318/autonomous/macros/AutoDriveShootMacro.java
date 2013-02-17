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
	private int fireState = 0;
	private int timesFired = 0;
	
	private double stateStartTime;
	private double leftPositionBeforeRotation;
	private double rightPositionBeforeRotation;
	private double initWaitTime = 3000000;//3 seconds
	private double waitForPistonsTime = 500000;//.5 seconds TODO
	private double shootPosition = 0;//TODO
	private double backedUpPosition = 0;//TODO
	private double driveForwardSpeed = .3;//TODO
	private double driveBackSlowlySpeed = -.1;//TODO
	private double driveBackSpeed = -driveForwardSpeed;
	private double driveForwardSlowlySpeed = -driveBackSlowlySpeed;
	private double stop = 0;
	private double tooFarForward = 1000;//TODO
	private double tooFarBack = -tooFarForward;
	private double shooterMotorSetPoint = .75;//TODO
	private double shooterMinSpeed = 0;//TODO
	private double shooterMaxSpeed = 0;//TODO
	private double rotateClockwise = .3;//TODO
	private double rotateCounterClockwiseSlowly = -.1;//TODO
	private double rotationDistance = 0;//TODO
	
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
			hasFinished = true;
			break;
		}
	}

	public void cancel() {
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(stop);
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(stop);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(stop);
		ReferenceData.getInstance().getUserInputData().setJoystickX(stop);
		ReferenceData.getInstance().getUserInputData().setJoystickY(stop);
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		ReferenceData.getInstance().getUserInputData().setLiftDown(false);
		ReferenceData.getInstance().getUserInputData().setShooterUp(false);
		ReferenceData.getInstance().getUserInputData().setShooterDown(true);
		ReferenceData.getInstance().getUserInputData().setShooterFire(false);
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
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 >= backedUpPosition) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveBackSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveBackSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveBackSpeed);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 <= backedUpPosition + tooFarBack) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveForwardSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveForwardSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveForwardSlowlySpeed);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickY(stop);
			if(timer.get() - stateStartTime >= waitForPistonsTime) {
				currentState = StateRef.DRIVE_TO_LAUNCH_POSITION;
				newState = true;
			}
		}
	}
	
	private void driveToLaunchPosition() {
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(shooterMotorSetPoint);
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 <= shootPosition) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveForwardSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveForwardSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveForwardSpeed);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 >= shootPosition + tooFarForward) {
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
				&& timer.get() - stateStartTime >= waitForPistonsTime) {
			currentState = StateRef.FIRE;
			newState = true;
		}
	}
	
	private void fire() {
		if(timesFired < 3) {
			switch(fireState) {
			case 0: //Retract piston
				if(newState) {
					stateStartTime = timer.get();
					newState = false;
				}
				ReferenceData.getInstance().getUserInputData().setShooterFire(true);
				if(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() >= shooterMinSpeed 
						&& ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() <= shooterMaxSpeed 
						&& timer.get() - stateStartTime >= waitForPistonsTime) {
					fireState = 1;
					newState = true;
				}
				break;
			case 1: //Extend piston
				if(newState) {
					stateStartTime = timer.get();
					newState = false;
				}
				ReferenceData.getInstance().getUserInputData().setShooterFire(false);
				if(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() >= shooterMinSpeed 
						&& ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() <= shooterMaxSpeed 
						&& timer.get() - stateStartTime >= waitForPistonsTime) {
					fireState = 0;
					timesFired++;
					newState = true;
				}
				break;
			default:
				break;
			}
		}
		currentState = StateRef.PREPARE_TO_DRIVE;
	}
	
	private void prepareToDrive() {
		if(newState) {
			ReferenceData.getInstance().getUserInputData().setLiftUp(true);
			ReferenceData.getInstance().getUserInputData().setShooterDown(true);
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(stop);
			stateStartTime = timer.get();
			newState = false;
		}
		if(timer.get() - stateStartTime >= waitForPistonsTime) {
			currentState = StateRef.BACK_UP;
			newState = true;
		}
	}
	
	private void backUp() {
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 >= backedUpPosition) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveBackSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveBackSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveBackSpeed);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 <= backedUpPosition + tooFarBack) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveForwardSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveForwardSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickY(driveForwardSlowlySpeed);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickY(stop);
			currentState = StateRef.ROTATE;
		}
	}
	
	private void rotate() {
		if(newState) {
			leftPositionBeforeRotation = ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
			rightPositionBeforeRotation = ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
			newState = false;
		}
		if(ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() <= leftPositionBeforeRotation + rotationDistance
				&& ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() >= rightPositionBeforeRotation - rotationDistance) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveForwardSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveBackSpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickX(rotateClockwise);
		} else if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() >= leftPositionBeforeRotation + rotationDistance + tooFarForward
				&& ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() <= rightPositionBeforeRotation - rotationDistance + tooFarBack) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(driveBackSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(driveForwardSlowlySpeed);
			ReferenceData.getInstance().getUserInputData().setJoystickX(rotateCounterClockwiseSlowly);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(stop);
			ReferenceData.getInstance().getUserInputData().setJoystickX(stop);
			currentState = StateRef.DONE;
			newState = true;
		}
	}
}
