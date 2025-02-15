package org.usfirst.frc1318.FRC2013.calculatorsTest;

import org.usfirst.frc1318.FRC2013.calculators.DriveTrain2JoysticksCalculator;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class DriveTrain2JoysticksCalculatorTest {
	
	DriveTrain2JoysticksCalculator calc;
	
	@Before
	public void setUpDriveTrain2JoysticksCalculatorTest(){
		calc = new DriveTrain2JoysticksCalculator();
	}
	
	@Test
	public void LeftSetPointPositive1(){
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(1);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint(), .001);
	}
	
	@Test
	public void LeftSetPointPositiveInBounds(){
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(.45);
		calc.teleopPeriodic();
		assertEquals(.45, ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint(), .001);
	}
	
	@Test
	public void LeftSetPointNegitive1(){
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(-1);
		calc.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint(), .001);
	}
	
	@Test
	public void LeftSetPointNegitiveInBounds(){
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(-.65);
		calc.teleopPeriodic();
		assertEquals(-.65, ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint(), .001);
	}
	
	@Test
	public void LeftSetPoint0(){
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(0);
		calc.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData().getLeftSpeedSetPoint(), .001);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void RightSetPointPositive1(){
		ReferenceData.getInstance().getUserInputData().setJoystickRight(1);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint(), .001);
	}
	
	@Test
	public void RightSetPointPositiveInBounds(){
		ReferenceData.getInstance().getUserInputData().setJoystickRight(.34);
		calc.teleopPeriodic();
		assertEquals(.34, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint(), .001);
	}
	
	@Test
	public void RightSetPointNegitive1(){
		ReferenceData.getInstance().getUserInputData().setJoystickRight(-1);
		calc.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint(), .001);
	}
	
	@Test
	public void RightSetPointNegitiveInBounds(){
		ReferenceData.getInstance().getUserInputData().setJoystickRight(-.75);
		calc.teleopPeriodic();
		assertEquals(-.75, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint(), .001);
	}
	
	@Test
	public void RightSetPoint0(){
		ReferenceData.getInstance().getUserInputData().setJoystickRight(0);
		calc.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData().getRightSpeedSetPoint(), .001);
	}
	
}
