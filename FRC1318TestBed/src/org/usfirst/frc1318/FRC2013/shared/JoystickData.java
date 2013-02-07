package org.usfirst.frc1318.FRC2013.shared;

public class JoystickData {
	
	private double joystickL;
	private double joystickR;
	
	public double getJoystickR(){
		return joystickR;
	}
	
	public void setJoystickR(double val){
		if(val > 1 || val < -1){
			val = val / Math.abs(val);
		}
		joystickR = val;
	}
	
	public double getJoystickL(){
		return joystickL;
	}
	
	public void setJoystickL(double val){
		if(val > 1 || val < -1){
			val = val / Math.abs(val);
		}
		joystickL = val;
	}

}
