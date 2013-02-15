package org.usfirst.frc1318.FRC2013.shared;

public class UserInputData {
	
	private int userInputType;

	private double joystickLeft;
	private double joystickRight;
	private double joystickX;
	private double joystickY;
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
	
	
	public boolean getLiftDown() {
		return liftDown;
	}
	
	public void setLiftDown(boolean liftDown) {
		this.liftDown = liftDown;
	}
	
	public boolean getLiftUp() {
		return liftUp;
	}
	
	public void setLiftUp(boolean liftUp) {
		this.liftUp = liftUp;
	}
	
	public boolean getShooterDown() {
		return shooterDown;
	}
	
	public void setShooterDown(boolean shooterDown) {
		this.shooterDown = shooterDown;
	}
	
	public boolean getShooterUp() {
		return shooterUp;
	}
	
	public void setShooterUp(boolean shooterUp) {
		this.shooterUp = shooterUp;
	}
	
	public boolean getShooterSpeedUp() {
		return shooterSpeedUp;
	}
	
	public void setShooterSpeedUp(boolean shooterSpeedUp) {
		this.shooterSpeedUp = shooterSpeedUp;
	}
	
	public boolean getShooterSpeedDown() {
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

	public double getJoystickLeft() {
		return joystickLeft;
	}

	public void setJoystickLeft(double joystickAxis1) {
		this.joystickLeft = joystickAxis1;
	}

	public double getJoystickRight() {
		return joystickRight;
	}

	public void setJoystickRight(double joystickAxis2) {
		this.joystickRight = joystickAxis2;
	}

	public double getJoystickX()
	{
		return joystickX;
	}

	public void setJoystickX(double joystickX)
	{
		this.joystickX = joystickX;
	}

	public double getJoystickY()
	{
		return joystickY;
	}

	public void setJoystickY(double joystickY)
	{
		this.joystickY = joystickY;
	}
	
}
