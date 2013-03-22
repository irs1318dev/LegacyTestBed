package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;
import org.usfirst.frc1318.autonomous.AutonomousMode;

public class AutoFireWhenReady extends AutonomousMode {

	private static final double SHOOTER_OFFSET = -0.05;
	private static final double SHOOTER_RESTORE_OFFSET = 0.02;
	private static final long FIRE_WAIT = 50;
	
	private boolean hasFinished = false;
	private boolean hasInitialized = false;
	private boolean newState = true;
	
	private int currentState;
	
	public void run() {
		System.out.println("*******************************************AutoFireAll currentState: " + currentState);
		switch(currentState){
			case 0:
				saveShooterSetPoint();
				break;
			case 1:
				setFireSetPoint();
				break;
			case 2:
				fireWhenReady();
				break;
			case 3:
				andWait(FIRE_WAIT);
				break;
			case 4:
				setRestoreSetPoint();
				break;
			case 5:
				restoreShooterSetPoint();
				break;
			default:
				hasFinished = true;
				break;
		}
		
	}
	
	private double shooterSetPoint;
	private double fireSetPoint;
	private double restoreSetPoint;
	
	public void saveShooterSetPoint() {
		shooterSetPoint = ReferenceData.getInstance().getShooterData().getMotorSetPoint();
		nextState();
	}

	public void setFireSetPoint() {
		fireSetPoint = shooterSetPoint + SHOOTER_OFFSET;
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(fireSetPoint);
		nextState();
	}
	
	public void fireWhenReady() {
		double shooterEncoderAngularVelocity = ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity();
		if(shooterEncoderAngularVelocity <= shooterSetPoint) { //negative is higher speed
			ReferenceData.getInstance().getUserInputData().setShooterFire(true);
			nextState();
		}
	}
	
	public void setRestoreSetPoint() {
		restoreSetPoint = shooterSetPoint + SHOOTER_RESTORE_OFFSET;
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(restoreSetPoint);
		nextState();
	}

	public void restoreShooterSetPoint() {
		double shooterEncoderAngularVelocity = ReferenceData.getInstance().getShooterData().getEncoderAngularVelocity();
		if(shooterEncoderAngularVelocity > shooterSetPoint) { //negative is higher speed
			ReferenceData.getInstance().getShooterData().setMotorSetPoint(shooterSetPoint);
			nextState();
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
