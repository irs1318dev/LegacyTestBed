package org.usfirst.frc1318.fall2013Teaching;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.usfirst.frc1318.fall2013.teaching.Calculator;

public class CalculatorTest {

	private Calculator cal = new Calculator();
	
	@Test
	public void addTest(){
		int c = cal.add(3, 5);
		assertEquals(c, 8);
	}
	
	@Test
	public void subtractTest(){
		assertEquals(cal.subtract(5, 4), 1);
	}
	
	@Test
	public void multiplyTest(){
		assertEquals(cal.multiply(3, 2), 6);
	}
	
	@Test
	public void divideTest(){
		assertEquals(cal.divide(10, 2), 5);
	}
	
	@Test
	public void numberSizeTest(){
		cal.numberSize(2, 4);
	}
	
}
