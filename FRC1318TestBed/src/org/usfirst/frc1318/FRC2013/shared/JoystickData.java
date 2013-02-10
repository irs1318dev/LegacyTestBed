package org.usfirst.frc1318.FRC2013.shared;

public class JoystickData {
	
	private double joystickLY;
	private double joystickRY;
	private double joystickLX;
	private double joystickRX;

	private boolean liftUp1;
	private boolean liftUp2;
	private boolean liftDown;
	
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

	
	public boolean getLiftUp1() {
		return liftUp1;
	}
	
	public void setLiftUp1(boolean newValue) {
		this.liftUp1 = newValue;
	}
	
	
	public boolean getLiftUp2() {
		return liftUp2;
	}
	
	public void setLift2(boolean newValue) {
		this.liftUp2 = newValue;
	}
	
	
	public boolean getLiftDown() {
		return liftDown;
	}
	
	public void setLiftDown(boolean newValue) {
		this.liftDown = newValue;
	}

}
