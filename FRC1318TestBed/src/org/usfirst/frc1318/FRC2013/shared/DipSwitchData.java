package org.usfirst.frc1318.FRC2013.shared;

public class DipSwitchData {
	
	private boolean[] switches = new boolean[8];
	
	public void setDipSwitch(int dipSwitch, boolean value){
		if(switches[dipSwitch - 1] != value)
			System.out.println("dip switch " + dipSwitch + ": " + value);
		switches[dipSwitch - 1] = value;
	}
	
	public boolean getDipSwitch(int dipSwitch){
		System.out.print("Getting switch " + dipSwitch + ": ");
		System.out.println(switches[dipSwitch - 1]);
		return switches[dipSwitch - 1];
	}
	
//	public boolean getDipSwitch1(){
//		return switches[0];
//	}
//	
//	public void setDipSwitch1(boolean value){
//		if(switches[0] != value)
//			System.out.println("dip switch 1: " + value);
//		switches[0] = value;
//	}
//	
//	public boolean getDipSwitch2(){
//		return switches[1];
//	}
//	
//	public void setDipSwitch2(boolean value){
//		if(switches[1] != value)
//			System.out.println("dip switch 2: " + value);
//		switches[1] = value;
//	}
//	
//	public boolean getDipSwitch3(){
//		return switches[2];
//	}
//	
//	public void setDipSwitch3(boolean value){
//		if(switches[2] != value)
//			System.out.println("dip switch 3: " + value);
//		switches[2] = value;
//	}
//	
//	public boolean getDipSwitch4(){
//		return switches[3];
//	}
//	
//	public void setDipSwitch4(boolean value){
//		if(switches[3] != value)
//			System.out.println("dip switch 4: " + value);
//		switches[3] = value;
//	}
//	
//	public boolean getDipSwitch5(){
//		return switches[4];
//	}
//	
//	public void setDipSwitch5(boolean value){
//		if(switches[4] != value)
//			System.out.println("dip switch 5: " + value);
//		switches[4] = value;
//	}
//	
//	public boolean getDipSwitch6(){
//		return switches[5];
//	}
//	
//	public void setDipSwitch6(boolean value){
//		if(switches[5] != value)
//			System.out.println("dip switch 6: " + value);
//		switches[5] = value;
//	}
//	
//	public boolean getDipSwitch7(){
//		return switches[6];
//	}
//	
//	public void setDipSwitch7(boolean value){
//		if(switches[6] != value)
//			System.out.println("dip switch 7: " + value);
//		switches[6] = value;
//	}
//	
//	public boolean getDipSwitch8(){
//		return switches[7];
//	}
//	
//	public void setDipSwitch8(boolean value){
//		if(switches[7] != value)
//			System.out.println("dip switch 8: " + value);
//		switches[7] = value;
//	}

}
