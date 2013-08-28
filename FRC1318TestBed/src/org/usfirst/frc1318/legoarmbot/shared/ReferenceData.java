package org.usfirst.frc1318.legoarmbot.shared;




public class ReferenceData {
	
	private static ReferenceData instance;
	private UserInputData userInputData;
	private ArmData armData;
	
	private ReferenceData(){
	}
	
	public static ReferenceData getInstance(){
		if(instance == null){
			instance = new ReferenceData();
		}
		return instance;
	}
	
	public ArmData getArmData(){
		if(armData == null) {
			armData = new ArmData();
		}
		return armData;
	}
	
	public UserInputData getUserInputData(){
		if(userInputData == null){
			userInputData = new UserInputData();
		}
		return userInputData;
	}
	
}
