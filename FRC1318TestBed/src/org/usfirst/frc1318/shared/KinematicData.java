package org.usfirst.frc1318.shared;

public class KinematicData {
	private static KinematicData instance;
	
	public static KinematicData getInstance() {
		if(instance == null)
			instance = new KinematicData();
		return instance;
	}
	
	private KinematicData() {}

	public void clear() {
		instance = new KinematicData();
	}

}
