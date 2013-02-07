package org.usfirst.frc1318.FRC2013.shared;

public class ReferenceData {
	
	private static ReferenceData instance;
	private JoystickData joystickData;
	private DriveTrainData driveTrainData;
	
	private ReferenceData(){
	}
	
	public static ReferenceData getInstance(){
		if(instance == null){
			instance = new ReferenceData();
		}
		return instance;
	}
	
	public JoystickData getJoystickData(){
		if(joystickData == null){
			joystickData = new JoystickData();
		}
		return joystickData;
	}
	public void setJoystickData(JoystickData newData){
		joystickData = newData;
	}
	
	public DriveTrainData getDriveTrainData(){
		if(driveTrainData == null){
			driveTrainData = new DriveTrainData();
		}
		return driveTrainData;
	}
	public void setDriveTrainData(DriveTrainData newData){
		driveTrainData = newData;
	}

}
