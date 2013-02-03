package org.usfirst.frc1318.generic.shared;

public class ReferenceData {
	
	private static ReferenceData instance;
	
	private GamePadData gamePadData;
	
	public static ReferenceData getInstance() {
		if(instance == null)
			instance = new ReferenceData();
		return instance;
	}
	
	private ReferenceData() {}

	public GamePadData getGamePadData() {
		if(gamePadData == null)
			gamePadData = new GamePadData();
		return gamePadData;
	}
	
	public void setGamePadData(GamePadData newData) {
		this.gamePadData = newData;
	}
	
	public void clear() {
		instance = new ReferenceData();
	}
}