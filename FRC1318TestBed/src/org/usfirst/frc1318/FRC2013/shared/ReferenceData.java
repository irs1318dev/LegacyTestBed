package org.usfirst.frc1318.FRC2013.shared;

import org.usfirst.frc1318.generic.shared.GamePadData;

public class ReferenceData {
	
	private static ReferenceData instance;
	private JoystickData joystickData;
	private DriveTrainData driveTrainData;
	private LifterData lifterData;
	private LifterLimitSwitchData lifterLimitSwitchData;
	private ShooterData shooterData;
	private GamePadData gamePadData;
	private SolenoidTestData solenoidTestData;
	private UserInputData userInputData;
	
	private ReferenceData(){
	}
	
	public static ReferenceData getInstance(){
		if(instance == null){
			instance = new ReferenceData();
		}
		return instance;
	}
	
	public GamePadData getGamePadData(){
		if(gamePadData == null){
			gamePadData = new GamePadData();
		}
		return gamePadData;
	}
	
	public UserInputData getUserInputData(){
		if(userInputData == null){
			userInputData = new UserInputData();
		}
		return userInputData;
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
	

	public LifterData getLifterData() {
		if (lifterData == null) {
			lifterData = new LifterData();
		}
		return lifterData;
	}
	public void setLiferData(LifterData newData) {
		lifterData = newData;
	}

	public LifterLimitSwitchData getLifterLimitSwitchData() {
		if (lifterLimitSwitchData == null) {
			lifterLimitSwitchData = new LifterLimitSwitchData();
		}
		return lifterLimitSwitchData;
	}
	public void setLifterLimitSwitchData(LifterLimitSwitchData newData) {
		lifterLimitSwitchData = newData;
	}

	public ShooterData getShooterData(){
		if(shooterData == null)
			shooterData = new ShooterData();
		return shooterData;
	}
	public void setShooterData(ShooterData newData){
		shooterData = newData;
	}
	
	public SolenoidTestData getSolenoidTestData()
	{
		if (this.solenoidTestData == null){
			solenoidTestData = new SolenoidTestData();
		}
		return solenoidTestData;
	}
	
	public void setUserInputData(UserInputData newData){
		userInputData = newData;
	}
}
