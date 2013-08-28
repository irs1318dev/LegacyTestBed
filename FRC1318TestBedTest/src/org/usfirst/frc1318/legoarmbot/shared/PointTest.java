package org.usfirst.frc1318.legoarmbot.shared;

import static org.junit.Assert.*;

import org.junit.Test;

import org.usfirst.frc1318.legoarmbot.shared.*;

public class PointTest {
	
	@Test
	public void equalsTest() {
		Point test = new Point(3, 4);

		Point isNull = null;
		Object isNotAPoint = new Object();
		Point isNotEqual = new Point(2, 5);
		Point isEqual = new Point(3, 4);
		
		assertFalse(test.equals(isNull));
		assertFalse(test.equals(isNotAPoint));
		assertFalse(test.equals(isNotEqual));
		assertTrue(test.equals(isEqual));
	}
	
	@Test
	public void equalsWithinAcceptableEpsilonTest() {
		Point test = new Point(3, 4);
		Point shouldBeEqual = new Point(3.0000005, 3.9999999994);
		assertTrue(test.equals(shouldBeEqual));
	}

}