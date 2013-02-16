package org.usfirst.frc1318.FRC2013.shared;


public class ReferenceData {
	
	private static ReferenceData instance;
	private DriveTrainData driveTrainData;
	private LifterData lifterData;
	private LifterLimitSwitchData lifterLimitSwitchData;
	private ShooterData shooterData;
	private SolenoidData solenoidData;
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
	
	public UserInputData getUserInputData(){
		if(userInputData == null){
			userInputData = new UserInputData();
		}
		return userInputData;
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
	
	public SolenoidData getSolenoidData(){
		if(solenoidData == null)
			solenoidData = new SolenoidData();
		return solenoidData;
	}

	public void setSolenoidData(SolenoidData solenoidData)
	{
		this.solenoidData = solenoidData;
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
