package org.usfirst.frc1318.shared;

public class TBThroughBeamData {
	
	private static boolean isBroken;
	
	public static boolean get(){
		return isBroken;
	}
	
	public static void set(boolean broken){
		isBroken = broken;
	}

}
