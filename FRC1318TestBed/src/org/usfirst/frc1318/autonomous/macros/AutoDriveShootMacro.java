package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;

import edu.wpi.first.wpilibj.Timer;


public class AutoDriveShootMacro implements AutoTask {
	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	private boolean newState = true;
	
	final int INITIALIZE = 0;
	final int PREPRARE_TO_DRIVE_UNDER_PYRAMID = 1;
	final int DRIVE_TO_LAUNCH_POSITION = 2;
	final int PREPARE_TO_SHOOT = 3;
	final int FIRE = 4;
	final int PREPARE_TO_DRIVE = 5;
	final int BACK_UP = 6;
	final int ROTATE = 7;
	final int AUTO_DRIVE_SHOOT_MACRO_DEFAULT = INITIALIZE;
	
	private int currentState = AUTO_DRIVE_SHOOT_MACRO_DEFAULT;
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
		case INITIALIZE:
			initialize();
			break;
		case PREPRARE_TO_DRIVE_UNDER_PYRAMID:
			prepareToDriveUnderPyramid();
			break;
		case DRIVE_TO_LAUNCH_POSITION:
			driveToLaunchPosition();
			break;
		case PREPARE_TO_SHOOT:
			prepareToShoot();
			break;
		case FIRE:
			fire();
			break;
		case PREPARE_TO_DRIVE:
			prepareToDrive();
			break;
		case BACK_UP:
			backUp();
			break;
		case ROTATE:
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
			currentState = PREPRARE_TO_DRIVE_UNDER_PYRAMID;
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
				currentState = DRIVE_TO_LAUNCH_POSITION;
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
			currentState = PREPARE_TO_SHOOT;
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
			currentState = FIRE;
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
		currentState = PREPARE_TO_DRIVE;
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
			currentState = BACK_UP;
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
			currentState = ROTATE;
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
			currentState++;
			newState = true;
		}
	}
}
