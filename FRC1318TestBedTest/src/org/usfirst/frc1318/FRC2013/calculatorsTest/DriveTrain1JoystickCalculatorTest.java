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
	public void setUpDriveTrain2JoysticksCalculatorTest() {
		calc = new DriveTrain1JoystickCalculator();
		calc.setXScaleFactor(1);
		calc.setYScaleFactor(1);
	}

	// Takes into account backwards right motor!!!
	@Test
	public void goStraight() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(1);
		ReferenceData.getInstance().getUserInputData().setJoystickX(0);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), .001);
	}

	// TODO: figure out what the physical meaning of tests is
	@Test
	public void goBack() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(-1);
		ReferenceData.getInstance().getUserInputData().setJoystickX(0);
		calc.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void spinRight() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		ReferenceData.getInstance().getUserInputData().setJoystickX(1);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void spinLeft() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(0);
		ReferenceData.getInstance().getUserInputData().setJoystickX(-1);
		calc.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotRightForward() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(0.707107);
		ReferenceData.getInstance().getUserInputData().setJoystickX(0.707107);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotLeftForward() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(0.707107);
		ReferenceData.getInstance().getUserInputData().setJoystickX(-0.707107);
		calc.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotRightBackward() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(-0.707107);
		ReferenceData.getInstance().getUserInputData().setJoystickX(0.707107);
		calc.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotLeftBackward() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(-0.707107);
		ReferenceData.getInstance().getUserInputData().setJoystickX(-0.707107);
		calc.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void gentleLeftForward() {
		ReferenceData.getInstance().getUserInputData().setJoystickY(0.5);
		ReferenceData.getInstance().getUserInputData().setJoystickX(-0.866025);
		calc.teleopPeriodic();
		assertEquals(-0.26795, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

}
