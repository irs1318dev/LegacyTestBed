package org.usfirst.frc1318.FRC2013.shared;

import edu.wpi.first.wpilibj.networktables2.util.Set;

public class LookupTable {
	private final double[] SHOOTERVALUES = {0, -0.800, -0.885, -1.54};
	public static int currentState;
	
	public double getValue()
	{
		//TODO: Rough understanding of throttle
		return SHOOTERVALUES[currentState];// - ReferenceData.getInstance().getUserInputData().getThrottle();
	}
	
	public void upSpeed()
	{
		//if(currentState == 3)
		//	currentState = 0;
		if(currentState <3)
			currentState++;
	}
	
	public void downSpeed()
	{
		//if (currentstate == 0)
		//	currentState = 3;
		if(currentState >0)
			currentState--;
	}

	public void setCurrentState(int i) {
		currentState = i;
	}
}
