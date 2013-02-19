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
	
	private final double INIT_WAIT_TIME = 3000000;//3 seconds
	private final double WAIT_FOR_PISTONS_TIME = 500000;//.5 seconds TODO
	private final double SHOOT_POSITION = 0;//TODO
	private final double BACKED_UP_POSITION = 0;//TODO
	private final double DRIVE_FORWARD_SPEED = .3;//TODO
	private final double DRIVE_BACK_SLOWLY_SPEED = -.1;//TODO
	private final double DRIVE_BACK_SPEED = -DRIVE_FORWARD_SPEED;
	private final double DRIVE_FORWARD_SLOWLY_SPEED = -DRIVE_BACK_SLOWLY_SPEED;
	private final double STOP = 0;
	private final double TOO_FAR_FORWARD = 1000;//TODO
	private final double TOO_FAR_BACK = -TOO_FAR_FORWARD;
	private final double SHOOTER_MOTOR_SET_POINT = .75;//TODO
	private final double SHOOTER_MIN_SPEED = 0;//TODO
	private final double SHOOTER_MAX_SPEED = 0;//TODO
	private final double ROTATE_CLOCKWISE = .3;//TODO
	private final double ROTATE_COUNTER_CLOCKWISE_SLOWLY = -.1;//TODO
	private final double ROTATOION_DISTANCE = 0;//TODO
	
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
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(STOP);
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
		ReferenceData.getInstance().getUserInputData().setJoystickX(STOP);
		ReferenceData.getInstance().getUserInputData().setJoystickY(STOP);
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
		if(timer.get() - stateStartTime >= INIT_WAIT_TIME) {
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
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 >= BACKED_UP_POSITION) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_BACK_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_BACK_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickY(DRIVE_BACK_SPEED);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 <= BACKED_UP_POSITION + TOO_FAR_BACK) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_FORWARD_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_FORWARD_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickY(DRIVE_FORWARD_SLOWLY_SPEED);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickY(STOP);
			if(timer.get() - stateStartTime >= WAIT_FOR_PISTONS_TIME) {
				currentState = DRIVE_TO_LAUNCH_POSITION;
				newState = true;
			}
		}
	}
	
	private void driveToLaunchPosition() {
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(SHOOTER_MOTOR_SET_POINT);
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 <= SHOOT_POSITION) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_FORWARD_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_FORWARD_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickY(DRIVE_FORWARD_SPEED);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 >= SHOOT_POSITION + TOO_FAR_FORWARD) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_BACK_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_BACK_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickY(DRIVE_BACK_SLOWLY_SPEED);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickY(STOP);
			currentState = PREPARE_TO_SHOOT;
		}
	}
	
	private void prepareToShoot() {
		if(newState) {
			ReferenceData.getInstance().getUserInputData().setShooterUp(true);
			stateStartTime = timer.get();
			newState = false;
		}
		if(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() >= SHOOTER_MIN_SPEED 
				&& ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() <= SHOOTER_MAX_SPEED 
				&& timer.get() - stateStartTime >= WAIT_FOR_PISTONS_TIME) {
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
				if(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() >= SHOOTER_MIN_SPEED 
						&& ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() <= SHOOTER_MAX_SPEED 
						&& timer.get() - stateStartTime >= WAIT_FOR_PISTONS_TIME) {
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
				if(ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() >= SHOOTER_MIN_SPEED 
						&& ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity() <= SHOOTER_MAX_SPEED 
						&& timer.get() - stateStartTime >= WAIT_FOR_PISTONS_TIME) {
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
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(STOP);
			stateStartTime = timer.get();
			newState = false;
		}
		if(timer.get() - stateStartTime >= WAIT_FOR_PISTONS_TIME) {
			currentState = BACK_UP;
			newState = true;
		}
	}
	
	private void backUp() {
		if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks()) / 2 >= BACKED_UP_POSITION) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_BACK_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_BACK_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickY(DRIVE_BACK_SPEED);
		} else if((ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() + ReferenceData.getInstance().getDriveTrainData().getRightEncoder()) / 2 <= BACKED_UP_POSITION + TOO_FAR_BACK) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_FORWARD_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_FORWARD_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickY(DRIVE_FORWARD_SLOWLY_SPEED);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickY(STOP);
			currentState = ROTATE;
		}
	}
	
	private void rotate() {
		if(newState) {
			leftPositionBeforeRotation = ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks();
			rightPositionBeforeRotation = ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks();
			newState = false;
		}
		if(ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() <= leftPositionBeforeRotation + ROTATOION_DISTANCE
				&& ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() >= rightPositionBeforeRotation - ROTATOION_DISTANCE) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_FORWARD_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_BACK_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickX(ROTATE_CLOCKWISE);
		} else if (ReferenceData.getInstance().getDriveTrainData().getLeftEncoderTicks() >= leftPositionBeforeRotation + ROTATOION_DISTANCE + TOO_FAR_FORWARD
				&& ReferenceData.getInstance().getDriveTrainData().getRightEncoderTicks() <= rightPositionBeforeRotation - ROTATOION_DISTANCE + TOO_FAR_BACK) {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(DRIVE_BACK_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(DRIVE_FORWARD_SLOWLY_SPEED);
			ReferenceData.getInstance().getUserInputData().setJoystickX(ROTATE_COUNTER_CLOCKWISE_SLOWLY);
		} else {
			ReferenceData.getInstance().getUserInputData().setJoystickLeft(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickRight(STOP);
			ReferenceData.getInstance().getUserInputData().setJoystickX(STOP);
			currentState++;
			newState = true;
		}
	}
}
