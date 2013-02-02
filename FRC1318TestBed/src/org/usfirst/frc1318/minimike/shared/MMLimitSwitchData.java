package org.usfirst.frc1318.minimike.shared;

public class MMLimitSwitchData {
	
	static Object lock_right = new Object();
	static Object lock_left = new Object();
		
	private static boolean rightSwitch = false;
	private static boolean leftSwitch = false;

	public boolean getRightState(){
		synchronized(lock_right){
			return rightSwitch;
		}
	}
	
	public void setRightState(boolean state){
		//System.out.println("in right switch");
		synchronized(lock_right){
			rightSwitch = state;
			//System.out.println("right limit switch " + state + " hi");
		}
	}
	
	public boolean getLeftState(){
		synchronized(lock_left){
			return leftSwitch;
		}
	}
	
	public void setLeftState(boolean state){
		//System.out.println("in left switch");
		synchronized(lock_left){
			leftSwitch = state;
			//System.out.println("left limit switch " + state);
		}
	}
	
}
