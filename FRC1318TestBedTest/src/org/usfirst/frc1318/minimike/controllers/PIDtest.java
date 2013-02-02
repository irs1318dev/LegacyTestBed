package org.usfirst.frc1318.minimike.controllers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc1318.generic.controllers.PID;


//import org.mockito;

import edu.wpi.first.wpilibj.Timer;

public class PIDtest {

	PID controller;
	//Timer mockTimer;
	
	@Before
	public void setupPidTest()
	{
		//mockTimer = new Timer();
		
		//TODO update this line to match PID constructor
		controller = new PID(200, 1,1,1,1,-1,1);
		
		//controller.setTimer(mockTimer);
	}
	
	@Test
	public void IntegralTest()
	{
		controller.setSetpoint(200);
		
		//c is mocking a timer here
		int c = 0;
		double step = .0001;
		while(c*step < 1)
		{
			++c;
			controller.setTime(c*step);
			controller.input(200);
		}
		assertEquals(0, controller.getIntegral(), .01);
	}
	
	
	@Test
	public void DerivitaveTest()
	{
		//c is a mock timer
		int c = 0;
		double step = .001;
		while(c*step < 1)
		{
			++c;
			controller.setTime(c*step);
			controller.input(0 + .001 * c);
		}
		assertEquals(1, controller.getSlope(), .01);
	}
	
	
	
	//TODO use this to test out timer
	private void setTime(double time) {
		//when(mockTimer.get()).thenReturn(time);		
	}
}
