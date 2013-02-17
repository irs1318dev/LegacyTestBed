package org.usfirst.frc1318.FRC2013.calculatorsTest;

import static org.junit.Assert.*;

import org.junit.*;
import org.usfirst.frc1318.FRC2013.calculators.LifterCalculator;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

public class LifterCalculatorTest {
	LifterCalculator lifterCalculator;
	
	@Before
	public void setUpLifterCalculatorTest() {
		lifterCalculator = new LifterCalculator();
	}
	
	@Test
	public void testShouldLiftAlreadyFalseLiftUpFalseLiftDownFalse() {
		ReferenceData.getInstance().getLifterData().setShouldLift(false);
		ReferenceData.getInstance().getUserInputData().setLiftUp(false);
		ReferenceData.getInstance().getUserInputData().setLiftDown(false);
		lifterCalculator.teleopPeriodic();
		assertFalse(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyFalseLiftUpFalseLiftDownTrue() {
		ReferenceData.getInstance().getLifterData().setShouldLift(false);
		ReferenceData.getInstance().getUserInputData().setLiftUp(false);
		ReferenceData.getInstance().getUserInputData().setLiftDown(true);
		lifterCalculator.teleopPeriodic();
		assertFalse(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyFalseLiftUpTrueLiftDownFalse() {
		ReferenceData.getInstance().getLifterData().setShouldLift(false);
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		ReferenceData.getInstance().getUserInputData().setLiftDown(false);
		lifterCalculator.teleopPeriodic();
		assertTrue(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyFalseLiftUpTrueLiftDownTrue() {
		ReferenceData.getInstance().getLifterData().setShouldLift(false);
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		ReferenceData.getInstance().getUserInputData().setLiftDown(true);
		lifterCalculator.teleopPeriodic();
		assertFalse(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyTrueLiftUpFalseLiftDownFalse() {
		ReferenceData.getInstance().getLifterData().setShouldLift(true);
		ReferenceData.getInstance().getUserInputData().setLiftUp(false);
		ReferenceData.getInstance().getUserInputData().setLiftDown(false);
		lifterCalculator.teleopPeriodic();
		assertTrue(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyTrueLiftUpFalseLiftDownTrue() {
		ReferenceData.getInstance().getLifterData().setShouldLift(true);
		ReferenceData.getInstance().getUserInputData().setLiftUp(false);
		ReferenceData.getInstance().getUserInputData().setLiftDown(true);
		lifterCalculator.teleopPeriodic();
		assertFalse(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyTrueLiftUpTrueLiftDownFalse() {
		ReferenceData.getInstance().getLifterData().setShouldLift(true);
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		ReferenceData.getInstance().getUserInputData().setLiftDown(false);
		lifterCalculator.teleopPeriodic();
		assertTrue(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
	
	@Test
	public void testShouldLiftAlreadyTrueLiftUpTrueLiftDownTrue() {
		ReferenceData.getInstance().getLifterData().setShouldLift(true);
		ReferenceData.getInstance().getUserInputData().setLiftUp(true);
		ReferenceData.getInstance().getUserInputData().setLiftDown(true);
		lifterCalculator.teleopPeriodic();
		assertFalse(ReferenceData.getInstance().getLifterData().getShouldLift());
	}
}