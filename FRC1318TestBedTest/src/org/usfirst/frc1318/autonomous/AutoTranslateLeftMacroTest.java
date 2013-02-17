package org.usfirst.frc1318.autonomous;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc1318.FRC2013.runners.DriveTrainRunner;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.UserInputData;
import org.usfirst.frc1318.autonomous.macros.AutoTranslateLeftMacro;

import edu.wpi.first.wpilibj.Talon;


public class AutoTranslateLeftMacroTest {
	
	AutoRunner runner;
	AutoRunner runnerSpy;
	AutoTranslateLeftMacro macro;
	
	@Test
	public void macroTest(){
		
		runner = new AutoRunner();
		runnerSpy = spy(runner);
		macro = new AutoTranslateLeftMacro();
		
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(0);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(0);
		
		ReferenceData.getInstance().getUserInputData().setAutoTranslateLeft(true);
		runner.setTask(macro);
		runner.teleopPeriodic();
		
		assertTrue(runner.getTask().hasInitalized());
		
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(100);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(100);
		
		runner.teleopPeriodic();
		//goFoward1
		assertEquals(1, ReferenceData.getInstance().getUserInputData().getJoystickLeft(), .0001);
		assertEquals(1, ReferenceData.getInstance().getUserInputData().getJoystickRight(), .0001);
		assertEquals(0, ReferenceData.getInstance().getUserInputData().getJoystickX(), .0001);
		assertEquals(1, ReferenceData.getInstance().getUserInputData().getJoystickY(), .0001);

		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(1190);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(1190);
		
		runner.teleopPeriodic();
		runner.teleopPeriodic();
		//turnRight
		assertEquals(.5, ReferenceData.getInstance().getUserInputData().getJoystickLeft(), .0001);
		assertEquals(-.5, ReferenceData.getInstance().getUserInputData().getJoystickRight(), .0001);
		assertEquals(.5, ReferenceData.getInstance().getUserInputData().getJoystickX(), .0001);
		assertEquals(0, ReferenceData.getInstance().getUserInputData().getJoystickY(), .0001);
		
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(1300);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(1060);
		
		runner.teleopPeriodic();
		runner.teleopPeriodic();
		//goFoward2
		assertEquals(1, ReferenceData.getInstance().getUserInputData().getJoystickLeft(), .0001);
		assertEquals(1, ReferenceData.getInstance().getUserInputData().getJoystickRight(), .0001);
		assertEquals(0, ReferenceData.getInstance().getUserInputData().getJoystickX(), .0001);
		assertEquals(1, ReferenceData.getInstance().getUserInputData().getJoystickY(), .0001);
		
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(1510);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(1270);
		
		runner.teleopPeriodic();
		runner.teleopPeriodic();
		//turnLeft
		assertEquals(-.5, ReferenceData.getInstance().getUserInputData().getJoystickLeft(), .0001);
		assertEquals(.5, ReferenceData.getInstance().getUserInputData().getJoystickRight(), .0001);
		assertEquals(-.5, ReferenceData.getInstance().getUserInputData().getJoystickX(), .0001);
		assertEquals(0, ReferenceData.getInstance().getUserInputData().getJoystickY(), .0001);
		
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(1400);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(1400);
		
		runner.teleopPeriodic();
		runner.teleopPeriodic();
		//goBackwards
		assertEquals(-1, ReferenceData.getInstance().getUserInputData().getJoystickLeft(), .0001);
		assertEquals(-1, ReferenceData.getInstance().getUserInputData().getJoystickRight(), .0001);
		assertEquals(0, ReferenceData.getInstance().getUserInputData().getJoystickX(), .0001);
		assertEquals(-1, ReferenceData.getInstance().getUserInputData().getJoystickY(), .0001);
		
		ReferenceData.getInstance().getDriveTrainData().setLeftEncoderTicks(130);
		ReferenceData.getInstance().getDriveTrainData().setRightEncoderTicks(130);
		
		runner.teleopPeriodic();
		runner.teleopPeriodic();
		//hasFinished
		assertTrue(runner.getTask().hasFinished());
		
		
		//doReturn(mockLeftTalon).when(runnerSpy).getLeftTalon();
		//when(gamePad.getXRight()).thenReturn(val);
	}
	

}
