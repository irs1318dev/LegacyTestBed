package org.usfirst.frc1318.minimike.shared;

public class MMGamePadData {
	static Object lock_left = new Object();
	static Object lock_right = new Object();
	static Object lock_autonomous = new Object();
		
	static boolean leftButton = false;
	static boolean rightButton = false;
	static boolean autonomousButton = false;
	
	public boolean getLeftButton(){
		synchronized(lock_left){
			return leftButton;
		}
	}
	
	public void setLeftButton(boolean newValue){
		synchronized(lock_left){
			leftButton = newValue;
		}
	}
	
	public boolean getRightButton(){
		synchronized(lock_right){
			return rightButton;
		}
	}
	
	public void setRightButton(boolean newValue){
		synchronized(lock_right){
			rightButton = newValue;
		}
	}
	
	public boolean getAutonomousButton(){
		synchronized(lock_autonomous){
			return autonomousButton;
		}
	}
	
	public void setAutonomousButton(boolean newValue){
		synchronized(lock_autonomous){
			autonomousButton = newValue;
		}
	}
}
