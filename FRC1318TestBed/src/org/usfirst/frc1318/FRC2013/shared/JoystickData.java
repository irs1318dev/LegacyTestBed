package org.usfirst.frc1318.FRC2013.shared;

public class JoystickData {
	
	private double joystickLY;
	private double joystickRY;
	private double joystickLX;
	private double joystickRX;

	private boolean liftUp;
	private boolean liftDown;
	
	//TODO change to y and add x
	
	public double getJoystickRY(){
		return joystickRY;
	}
	
	public void setJoystickRY(double val){
		if(val > 1 || val < -1){
			val = val / Math.abs(val);
		}
		joystickRY = val;
	}
	
	public double getJoystickRX(){
		return joystickRX;
	}
	
	public void setJoystickRX(double val){
		if(val > 1 || val < -1){
			val = val / Math.abs(val);
		}
		joystickRX = val;
	}
	
	public double getJoystickLY(){
		return joystickLY;
	}
	
	public void setJoystickLY(double val){
		if(val > 1 || val < -1){
			val = val / Math.abs(val);
		}
		joystickLY = val;
	}
	
	public double getJoystickLX(){
		return joystickLX;
	}
	
	public void setJoystickLX(double val){
		if(val > 1 || val < -1){
			val = val / Math.abs(val);
		}
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
	
	

}
