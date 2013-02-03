package org.usfirst.frc1318.minimike.shared;

public class MMReferenceData {
	
	private static MMReferenceData instance;
	private MMLimitSwitchData limitSwitchData;
	private MMGamePadData gamePadData;
	private MMTurretData turretData;
	
	private MMReferenceData(){
	}
	
	public static MMReferenceData getInstance(){
		if(instance == null){
			instance = new MMReferenceData();
		}
		return instance;
	}
	
	public MMLimitSwitchData getMMLimitSwitchData(){
		if(limitSwitchData == null){
			limitSwitchData = new MMLimitSwitchData();
		}
		return limitSwitchData;
	}
	public void setMMLimitSwitchData(MMLimitSwitchData newData){
		limitSwitchData = newData;
	}
	
	public MMGamePadData getMMGamePadData(){
		if(gamePadData == null){
			gamePadData = new MMGamePadData();
		}
		return gamePadData;
	}
	public void setMMGamePadData(MMGamePadData newData){
		gamePadData = newData;
	}
	
	public MMTurretData getMMTurretData(){
		if(turretData == null){
			turretData = new MMTurretData();
		}
		return turretData;
	}
	public void setMMTuretData(MMTurretData newData){
		turretData = newData;
	}
}
