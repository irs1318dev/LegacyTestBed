package org.usfirst.frc1318.FRC2013.shared;

public class UserInputData {
	
	private int userInputType;

	private double joystickAxis1;
	private double joystickAxis2;
	private boolean liftDown;
	private boolean liftUp;
	private boolean shooterDown;
	private boolean shooterUp;
	private boolean shooterSpeedUp;
	private boolean shooterSpeedDown;
	private boolean shooterFire;
	
	public boolean getShooterFire() {
		return shooterFire;
	}

	public void setShooterFire(boolean shooterFire) {
		this.shooterFire = shooterFire;
	}

	//use these to set interface type
	public interface InterfaceType{
		final static int ONE_JOYSTICK_TO_DRIVE = 1;
		final static int TWO_JOYSTICKS_TO_DRIVE = 2;
		final static int ONE_GAMEPAD_STICK_TO_DRIVE = 3;
		final static int TWO_GAMEPAD_STICKS_TO_DRIVE = 4;
	}
	
	
	public boolean isLiftDown() {
		return liftDown;
	}
	
	public void setLiftDown(boolean liftDown) {
		this.liftDown = liftDown;
	}
	
	public boolean isLiftUp() {
		return liftUp;
	}
	
	public void setLiftUp(boolean liftUp) {
		this.liftUp = liftUp;
	}
	
	public boolean isShooterDown() {
		return shooterDown;
	}
	
	public void setShooterDown(boolean shooterDown) {
		this.shooterDown = shooterDown;
	}
	
	public boolean isShooterUp() {
		return shooterUp;
	}
	
	public void setShooterUp(boolean shooterUp) {
		this.shooterUp = shooterUp;
	}
	
	public boolean isShooterSpeedUp() {
		return shooterSpeedUp;
	}
	
	public void setShooterSpeedUp(boolean shooterSpeedUp) {
		this.shooterSpeedUp = shooterSpeedUp;
	}
	
	public boolean isShooterSpeedDown() {
		return shooterSpeedDown;
	}
	
	public void setShooterSpeedDown(boolean shooterSpeedDown) {
		this.shooterSpeedDown = shooterSpeedDown;
	}
	
	public int getUserInputType() {
		return userInputType;
	}

	public void setUserInputType(int userInputType) {
		this.userInputType = userInputType;
	}

	public double getJoystickAxis1() {
		return joystickAxis1;
	}

	public void setJoystickAxis1(double joystickAxis1) {
		this.joystickAxis1 = joystickAxis1;
	}

	public double getJoystickAxis2() {
		return joystickAxis2;
	}

	public void setJoystickAxis2(double joystickAxis2) {
		this.joystickAxis2 = joystickAxis2;
	}
	
}
