package org.usfirst.frc1318.reference;

public class PS2Controller extends GamePad {
	
	/**
	 * Squawk VM allows you to override static methods of the super class
	 */
	public static GamePad create(int port) {
		return new PS2Controller(port, GamePad.NUM_AXES, GamePad.NUM_BUTTONS);
	}
	
	public static interface PS2ButtonMap {
		int SQUARE = 4;
		int TRIANGLE = 1;
		int X = 3;
		int CIRCLE = 2;
		int START = 12;
		int SELECT = 9;
		int L1 = 7;
		int L2 = 5;
		int R1 = 8;
		int R2 = 6;
	}
	
	
	protected PS2Controller(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
	}
	
	public double getXRight() {
		return getRawAxis(GamePad.AXIS_Y2);
	}
	
	public double getYRight() {
		return -getRawAxis(GamePad.AXIS_X2);
	}
}