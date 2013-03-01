package org.usfirst.frc1318.FRC2013.controllers;

import org.usfirst.frc1318.components.RobotComponentBase;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc1318.FRC2013.reference.DipSwitchRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

public class DipSwitchReader extends RobotComponentBase{
	
	DigitalInput[] dipSwitches = new DigitalInput[8];
	
	public void robotInit(){
		
//		dipSwitches[0] = DipSwitchRef.DIP_SWITCH_1 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_1);
//		dipSwitches[1] = DipSwitchRef.DIP_SWITCH_2 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_2);
//		dipSwitches[2] = DipSwitchRef.DIP_SWITCH_3 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_3);
//		dipSwitches[3] = DipSwitchRef.DIP_SWITCH_4 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_4);
//		dipSwitches[4] = DipSwitchRef.DIP_SWITCH_5 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_5);
//		dipSwitches[5] = DipSwitchRef.DIP_SWITCH_6 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_6);
		dipSwitches[6] = DipSwitchRef.DIP_SWITCH_7 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_7);
		dipSwitches[7] = DipSwitchRef.DIP_SWITCH_8 == -1? null : new DigitalInput(DipSwitchRef.DIP_SWITCH_8);
		
		for(int i = 0; i < dipSwitches.length; i++){
			if(dipSwitches[i] != null){
				System.out.println("dip switch " + (i + 1) + " is connected to " + dipSwitches[i].getChannel());
			}
		}
		
		for(int i = 0; i < dipSwitches.length; i++){
			if(dipSwitches[i] != null){
				System.out.println("dip switch " + (i + 1) + " is set to " + dipSwitches[i].get());
				ReferenceData.getInstance().getDipSwitchData().setDipSwitch((i + 1), dipSwitches[i].get());
			}
		}
		
//		if(dipSwitches[0] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch1(dipSwitches[0].get());
//		if(dipSwitches[1] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch2(dipSwitches[1].get());
//		if(dipSwitches[2] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch3(dipSwitches[2].get());
//		if(dipSwitches[3] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch4(dipSwitches[3].get());
//		if(dipSwitches[4] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch5(dipSwitches[4].get());
//		if(dipSwitches[5] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch6(dipSwitches[5].get());
//		if(dipSwitches[6] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch7(dipSwitches[6].get());
//		if(dipSwitches[7] != null)
//			ReferenceData.getInstance().getDipSwitchData().setDipSwitch8(dipSwitches[7].get());
	}

	
	
	public void teleopPeriodic(){
		for(int i = 0; i < dipSwitches.length; i++){
			if(dipSwitches[i] != null){
//				System.out.println("dip switch " + (i + 1) + " is set to " + dipSwitches[i].get());
				ReferenceData.getInstance().getDipSwitchData().setDipSwitch((i + 1), dipSwitches[i].get());
			}
		}
		
	}

}
