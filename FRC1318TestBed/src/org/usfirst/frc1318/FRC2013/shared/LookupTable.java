package org.usfirst.frc1318.FRC2013.shared;

import edu.wpi.first.wpilibj.networktables2.util.Set;

public class LookupTable {
	private final double[] SHOOTERVALUES = {0, -0.25, -0.50, -0.75, -0.80, -0.82, -0.85, -0.87, -0.90, -0.92, -0.95, -0.97, -1.00, -1.25, -1.50, -1.75, -2.00, -2.25, -2.5, -2.75, -3};
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
		if(currentState < SHOOTERVALUES.length-1)
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
