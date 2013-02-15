package org.usfirst.frc1318.generic.shared;

public class GamePadData{
	private double joystickLY;
	private double joystickLX;
	private double joystickRY;
	private double joystickRX;
	
	private boolean[] buttons;
	
	public GamePadData()
	{
		buttons = new boolean[12];
	}
	
	public boolean getButton(int button)
	{
		try
		{
		return buttons[button-1];
		}
		catch (IndexOutOfBoundsException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public void setButton(int button, boolean pressed)
	{
		try
		{
			buttons[button-1] = pressed;
		}
		catch(IndexOutOfBoundsException ex)
		{
			ex.printStackTrace();
		}
	}
	
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
}
