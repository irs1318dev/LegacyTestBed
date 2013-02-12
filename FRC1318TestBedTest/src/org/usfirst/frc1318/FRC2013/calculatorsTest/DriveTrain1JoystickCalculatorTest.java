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
		ReferenceData.getInstance().getJoystickData().setJoystickLY(1);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(0);
		calc.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), .001);
	}

	// TODO: figure out what the physical meaning of tests is
	@Test
	public void goBack() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(-1);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(0);
		calc.teleopPeriodic();

		System.out.println("go Back \n Input: Y = -1, X = 0\n Output: L = "
				+ ReferenceData.getInstance().getDriveTrainData()
						.getLeftSpeedSetPoint()
				+ " R = "
				+ ReferenceData.getInstance().getDriveTrainData()
						.getRightSpeedSetPoint() + "\n\n");

		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void spinRight() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(0);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(1);
		calc.teleopPeriodic();

		System.out.println("Spin Right \n Input: Y = 0, X = 1\n Output: L = "
				+ ReferenceData.getInstance().getDriveTrainData()
						.getLeftSpeedSetPoint()
				+ " R = "
				+ ReferenceData.getInstance().getDriveTrainData()
						.getRightSpeedSetPoint() + "\n\n");

		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void spinLeft() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(0);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(-1);
		calc.teleopPeriodic();

		System.out.println("Spin Left \n Input: Y = 0, X = -1\n Output: L = "
				+ ReferenceData.getInstance().getDriveTrainData()
						.getLeftSpeedSetPoint()
				+ " R = "
				+ ReferenceData.getInstance().getDriveTrainData()
						.getRightSpeedSetPoint() + "\n\n");

		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotRightForward() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(0.707107);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(0.707107);
		calc.teleopPeriodic();

		System.out
				.println("pivot right forward \n Input: Y = 0.707107, X = 0.707107\n Output: L = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getLeftSpeedSetPoint()
						+ " R = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getRightSpeedSetPoint() + "\n\n");

		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotLeftForward() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(0.707107);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(-0.707107);
		calc.teleopPeriodic();

		System.out
				.println("pivot left forward hi \n Input: Y = 0.707107, X = -0.707107\n Output: L = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getLeftSpeedSetPoint()
						+ " R = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getRightSpeedSetPoint() + "\n\n");

		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotRightBackward() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(-0.707107);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(0.707107);
		calc.teleopPeriodic();

		System.out
				.println("pivot right backward \n Input: Y = -0.707107, X = 0.707107\n Output: L = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getLeftSpeedSetPoint()
						+ " R = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getRightSpeedSetPoint() + "\n\n");

		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void pivotLeftBackward() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(-0.707107);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(-0.707107);
		calc.teleopPeriodic();

		System.out
				.println("pivot left backward \n Input: Y = -0.707107, X = -0.707107\n Output: L = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getLeftSpeedSetPoint()
						+ " R = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getRightSpeedSetPoint() + "\n\n");

		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

	@Test
	public void gentleLeftForward() {
		ReferenceData.getInstance().getJoystickData().setJoystickLY(0.5);
		ReferenceData.getInstance().getJoystickData().setJoystickLX(-0.866025);
		calc.teleopPeriodic();

		System.out
				.println("gentle left forward \n Input: Y = 0.5, X = -0.866025\n Output: L = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getLeftSpeedSetPoint()
						+ " R = "
						+ ReferenceData.getInstance().getDriveTrainData()
								.getRightSpeedSetPoint() + "\n\n");

		assertEquals(-0.26795, ReferenceData.getInstance().getDriveTrainData()
				.getLeftSpeedSetPoint(), .001);
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData()
				.getRightSpeedSetPoint(), 0.001);
	}

}
