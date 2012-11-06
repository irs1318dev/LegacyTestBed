package org.usfirst.frc1318.shared;

public class ReferenceData {
	
	private static ReferenceData instance;
	
	public static ReferenceData getInstance() {
		if(instance == null)
			instance = new ReferenceData();
		return instance;
	}
	
	private ReferenceData() {}

	public void clear() {
		instance = new ReferenceData();
	}
	


}
