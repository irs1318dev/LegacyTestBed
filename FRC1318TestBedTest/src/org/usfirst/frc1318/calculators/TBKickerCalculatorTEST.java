package org.usfirst.frc1318.calculators;

import static org.junit.Assert.*;

import org.junit.*;
import org.usfirst.frc1318.runners.components.TBKickerCalculator;

public class TBKickerCalculatorTEST 
{
	TBKickerCalculator calc;
	
	@Before
	public void init()
	{
		calc = new TBKickerCalculator();
	}
	
	@Test
	public void buttonPressed()
	{
		boolean buttonPressed = true;
		assertEquals(true,calc.calculate(buttonPressed));
	}
	
	@Test
	public void 
}
