package org.usfirst.frc1318.runners.components;

public class TBSolenoidData {
	
	static boolean isKicked;
	
	public static boolean kicked(){
		return isKicked;
	}
	
	public static void setIfKicked(boolean ifKicked){
		isKicked = ifKicked;
	}

}
