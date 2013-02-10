package org.usfirst.frc1318.FRC2013.calculatorsTest;

import org.usfirst.frc1318.FRC2013.calculators.DriveTrain1JoystickCalculator;

import org.usfirst.frc1318.FRC2013.calculators.DriveTrain2JoysticksCalculator;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class DriveTrain1JoystickCalculatorTest {
	
	DriveTrain1JoystickCalculator calc;
	
	@Before
	public void setUpDriveTrain2JoysticksCalculatorTest(){
		calc = new DriveTrain1JoystickCalculator();
	}
	
	@Test
	public void goStraight(){
		ReferenceData.getInstance().getJoystickData().setJoystickLY(1);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(0);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint(), .001);
	}

}
