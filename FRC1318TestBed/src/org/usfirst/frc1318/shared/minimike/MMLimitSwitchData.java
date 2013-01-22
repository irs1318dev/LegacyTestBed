package org.usfirst.frc1318.shared.minimike;

public class MMLimitSwitchData {
	
	static final int HIT_LEFT = 0;
	static final int HIT_RIGHT = 1;
	static final int NOT_HIT = 2;
	static final int ERROR = 3;//both sensors hit
	
	static int state = NOT_HIT;
	
	public static int getData()
	{
		return state;
	}
	
	public static void setData(int newState)
	{
		state = newState;
	}
}
