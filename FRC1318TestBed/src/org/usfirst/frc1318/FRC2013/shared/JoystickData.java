package org.usfirst.frc1318.FRC2013.shared;

public class JoystickData {
	
	private double joystickLY;
	private double joystickRY;
	private double joystickLX;
	private double joystickRX;

	private boolean liftUp;
	private boolean liftDown;
	private boolean shooterUp;
	private boolean shooterDown;
	private boolean shooterSpeedUp;
	private boolean shooterSpeedDown;
	private boolean shooterFire;
	
	public double getJoystickRY(){
		return joystickRY;
	}
	
	public void setJoystickRY(double val){
		joystickRY = val;
	}
	
	
	public double getJoystickRX(){
		return joystickRX;
	}
	
	public void setJoystickRX(double val){
		joystickRX = val;
	}
	
	
	public double getJoystickLY(){
		return joystickLY;
	}
	
	public void setJoystickLY(double val){
		joystickLY = val;
	}
	
	
	public double getJoystickLX(){
		return joystickLX;
	}
	
	public void setJoystickLX(double val){
		joystickLX = val;
	}

	
	public boolean getLiftUp() {
		return liftUp;
	}
	
	public void setLiftUp(boolean newValue) {
		this.liftUp = newValue;
	}
	
	
	public boolean getLiftDown() {
		return liftDown;
	}
	
	public void setLiftDown(boolean newValue) {
		this.liftDown = newValue;
	}

	
	public boolean getShooterUp() {
		return shooterUp;
	}
	
	public void setShooterUp(boolean newValue) {
		this.shooterUp = newValue;
	}
	
	
	public boolean getShooterDown() {
		return shooterDown;
	}
	
	public void setShooterDown(boolean newValue) {
		this.shooterDown = newValue;
	}
	
	public boolean getShooterSpeedUp()
	{
		return shooterSpeedUp;
	}
	
	public void setShooterSpeedUp(boolean newValue){
		shooterSpeedUp = newValue;
	}
	
	public boolean getShooterSpeedDown()
	{
		return shooterSpeedDown;
	}
	
	public void setShooterSpeedDown(boolean newValue){
		shooterSpeedDown = newValue;
	}
	
	public boolean getShooterFire() {
		return shooterFire;
	}
	
	public void setShooterFire(boolean newValue) {
		this.shooterFire = newValue;
	}
}
