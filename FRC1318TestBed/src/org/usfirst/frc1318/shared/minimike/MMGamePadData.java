package org.usfirst.frc1318.shared.minimike;

public class MMGamePadData {
	static Object lock_left, lock_right;
	
	static boolean leftButton = false;
	static boolean rightButton = false;
	
	public static boolean getLeftButton(){
		synchronized(lock_left)
		{
			return leftButton;
		}
	}
	
	public static void setLeftButton(boolean newValue){
		synchronized(lock_left)
		{
			leftButton = newValue;
		}
	}
	
	public static boolean getRightButton(){
		synchronized(lock_right)
		{
			return rightButton;
		}
	}
	
	public static void setRightButton(boolean newValue){
		synchronized(lock_right)
		{
			rightButton = newValue;
		}
	}
}
