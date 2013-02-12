package org.usfirst.frc1318.FRC2013.controllersTest;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc1318.generic.controllers.PID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.wpi.first.wpilibj.Timer;

public class PIDtest {

	PID test;
	Timer mockTimer;
	
	@Before
	public void setupPidTest()
	{
		mockTimer = mock(Timer.class);
		
		test = new PID(0, 0, 0);
		
		test.setTimer(mockTimer);
		
	}
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculatesPTest() {
		test.setConstants(-3, 0,0,0);
		
		//required to update
		setTime(mockTimer.get() + .001);
		
		test.setSetpoint(5);
		test.input(10);
		
		assertEquals(-15.0, test.getOutput(), .001);
		
		//required to update
		setTime(mockTimer.get() + .001);
		
		test.setSetpoint(10);
		test.input(5);
		
		assertEquals(15.0, test.getOutput(), .001);
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculatesPTestNaN() {
		test.setConstants(-3, 0,0,0);
		
		setTime(mockTimer.get() + .001);
		
		test.setSetpoint(10);
		test.input(10);
		
		assertEquals(0, test.getOutput(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void calculateITestFadingMemoryDecreasingError() {
		test.setKi(1);
		test.setSetpoint(10);
		test.setKFade(.5); 
		
		test.input(26);
		incTime();
		test.input(18);
		incTime();
		test.input(14);
		
		assertEquals(8, test.getOutput(), .001);
	}
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculateITestNoFadingMemory() {
		test.setKi(1);
		test.setSetpoint(10);
		
		test.setKFade(1);
		
		setTime(1);
		test.input(13);
		setTime(2);
		test.input(15);
		setTime(3);
		test.input(8);
		assertEquals(6, test.getOutput(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculateIChangingTimes() {
		test.setKi(1);
		test.setKFade(1);
		
		test.setSetpoint(10);
		
		test.input(10);
		setTime(.23);
		test.input(10);
		setTime(.5);
		test.input(10);
		setTime(1);
		test.input(10);
		
		double expectedValue = 0 + (12-10)*(2 - 1); 
		
		setTime(2);
		test.input(12);
		assertEquals(expectedValue, test.getOutput(), 0.001);
		
		expectedValue += (16 - 10)*(2.25 - 2);
		
		setTime(2.25);
		test.input(16); 
		assertEquals(expectedValue, test.getOutput(), 0.001);
		
		expectedValue += (9 - 10)*(6.25 - 2.25);
		
		setTime(6.25);
		test.input(9);
		
		assertEquals(expectedValue, test.getOutput(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculateITestConstantError() {
		test.setKi(1);
		test.setSetpoint(10);
		
		test.input(10);
		incTime();
		test.input(10);
		incTime();
		
		test.setKFade(.5);
		double expectedValue = 0;
		
		test.input(18);
		expectedValue = 8;
		
		for(int i = 0; i < 10000; i++)
		{
			incTime();
			test.input(18);
			expectedValue *= .5;
			expectedValue += 8;
			assertEquals(expectedValue, test.getOutput(), .001);
		}
		
	}
	
	//D
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculateErrorDecreaseDTest() {
		setTime(mockTimer.get() + 1);
		
		test.setKd(3);
		
		test.setSetpoint(10);
		test.input(2);
		
		setTime(mockTimer.get() + 1);
		
		test.input(6);
		
		assertEquals(12.0, test.getOutput(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculateConstantErrorDelta() {
		
		//runs a few times to get values where they should be
		test.setKd(1.0);
		
		test.setSetpoint(10);
		test.input(6.0);
		
		setTime(mockTimer.get() + 1);
		
		test.input(6.0);
		
		setTime(mockTimer.get() + 1);
		
		test.input(6.0);

		assertEquals(0.0, test.getOutput(), 0.001);
		
		//updates a few more times with same value;
		for(int i= 0; i < 20; i++) {
			setTime(mockTimer.get() + 1);
			
			test.setSetpoint(10.0);
			test.input(6.0);
			
			assertEquals(0.0, test.getOutput(), 0.001);
		}
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void increasingErrorDelta() {
		test.setKd(1.0);//other constants zero
		boolean firstRun = true;
		for(double desired = 0.0; desired < 10.0; desired += 0.5) {
			//should increase error at a constant rate of 0.5
			if(firstRun) {
				//dt = 0, so output should be zero
				firstRun = false;
				
				test.setSetpoint(desired);
				test.input(0);
				
				assertEquals(0.0, test.getOutput(), 0.0001);
			}else {
				
				test.setSetpoint(desired);
				test.input(0);
				
				assertEquals(-500, test.getOutput(), 0.001);
			}
			setTime(mockTimer.get() + .001);
		}
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void decreasingErrorDelta() {
		test.setKd(1.0);//other constants zero
		
		test.setSetpoint(10.5);
		
		test.input(0);
		incTime();
		test.input(0);
		incTime();
		
		for(double desired = 10.0; desired > 0.0; desired -= 0.5) {
			//should increase error at a constant rate of -0.5
			
			test.setSetpoint(desired);
			test.input(0);
				   
			assertEquals(0.5, test.getOutput(), 0.0001);
			
			incTime();
		}
	}
	
	private void incTime() {
		setTime(getTime() + 1.0);
	}

	private double getTime() {
		return mockTimer.get();
	}

	//Feed-forward loop
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void calculateFTest() {
		test.setConstants(0, 0, 0);
		
		test.setKf(3);
		test.setSetpoint(10);
		incTime();
		test.input(12);
		incTime();
		test.input(30);
		assertEquals(30, test.getOutput(), 0.001);
	}
	
	//combined
	
////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void combinesPID() {
	
		//vars for test
		double setpoint = 10;
		double p = 0, i = 0, d = 0;
		double error = 0, lastError = 0;
		double input = 10;
		double expectedValue = 0;
		double predictableError = .31;
		double kFade = .5;
		double dt = 1;
		
		//initialize controller
		test.setConstants(3, 3, 3);
		test.setKFade(kFade);
		test.setSetpoint(10);
		
		//first two inputs
		test.input(10);
		incTime();
		test.input(10);
		incTime();
		
		//run test
		for(int c = 0; c < 1000; c++){
			
			//generate input with predictable error
			switch(c % 3){
			case 0:
				input = 10;
				break;
			case 1: 
				input = 10 - predictableError;
				break;
			case 2:
				input = 10 + predictableError;
				break;
			default:
				input = 10;
			}
			
			//do input
			test.input(input);
			
			//run test calculations
			error = input - setpoint;
			
			p = error;
			
			i *= kFade;
			i += error * dt;
			
			d = (error - lastError) * dt;
			
			//compare values
			expectedValue = 3 * p + 3 * i + 3 * d;
			assertEquals(expectedValue, test.getOutput(), .001);
			
			//prepare for next;
			incTime();
			lastError = error;
		}
		
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void addsInClamp() {
		test.setKp(1);
		test.setClampRatio(1); 
		test.setSetpoint(0);
		test.input(10);
		incTime();
		test.input(10);
		assertEquals(0, test.getOutput(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////

	@Test
	public void hasUpperBound() {
		
		test.setKp(1);
		test.setClampRange(-9000, 8); 
		test.setSetpoint(10);
		
		incTime();
		
		test.input(200);
		assertEquals(8, test.getOutput(), 0.001);	
	}

////////////////////////////////////////////////////////////////////////////////

	@Test
	public void hasLowerBound() {
		incTime();
		
		test.setKp(1);
		test.setClampRange(-5, 99999999999.0); 
		test.setSetpoint(10);
		test.input(-30);
		assertEquals(-5, test.getOutput(), 0.001);	
	}
	
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
	
	private void setTime(double time) {
		when(mockTimer.get()).thenReturn(time);		
	}

}
