package org.usfirst.frc1318.legoarmbot.shared;

public class UserInputData {
	
	double deltaX;
	double deltaY;
	double closedFormX;
	double closedFormY;
	boolean rightJoyStickActive; //when false, left joystick is active
	
	public double getDeltaX() {
		return deltaX;
	}
	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}
	public double getDeltaY() {
		return deltaY;
	}
	public void setDeltaY(double deltaY) {
		this.deltaY = deltaY;
	}
	public double getClosedFormX() {
		return closedFormX;
	}
	public void setClosedFormX(double closedFormX) {
		this.closedFormX = closedFormX;
	}
	public double getClosedFormY() {
		return closedFormY;
	}
	public void setClosedFormY(double closedFormY) {
		this.closedFormY = closedFormY;
	}
	public boolean isRightJoyStickActive() {
		return rightJoyStickActive;
	}
	public void setRightJoyStickActive(boolean joyStickMode) {
		this.rightJoyStickActive = joyStickMode;
	}

}
