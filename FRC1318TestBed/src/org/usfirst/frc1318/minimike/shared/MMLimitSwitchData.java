package org.usfirst.frc1318.minimike.shared;

public class MMLimitSwitchData {
	
	static Object lock_right, lock_left;
	
	public static MMLimitSwitchData instance;
	
	private static boolean rightSwitch = false;
	private static boolean leftSwitch = false;
	
	private MMLimitSwitchData(){
		
	}
	
	public static MMLimitSwitchData getInstance(){
		if(instance == null){
			instance = new MMLimitSwitchData();
		}
		return instance;
	}
	
	public boolean getRightState(){
		synchronized(lock_right){
			return rightSwitch;
		}
	}
	
	public void setRightState(boolean state){
		synchronized(lock_right){
			rightSwitch = state;
		}
	}
	
	public boolean getLeftState(){
		synchronized(lock_left){
			return leftSwitch;
		}
	}
	
	public void setLeftState(boolean state){
		synchronized(lock_left){
			leftSwitch = state;
		}
	}
	
}
