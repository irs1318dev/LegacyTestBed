package org.usfirst.frc1318.fall2013Teaching;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc1318.FRC2013.runners.DriveTrainRunner;
import org.usfirst.frc1318.fall2013.teaching.ArmData;
import org.usfirst.frc1318.fall2013.teaching.ArmRunner;

import edu.wpi.first.wpilibj.Talon;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.Before;

public class ArmRunnerTest {
	
	private ArmRunner runner;
	private ArmRunner runnerSpy;
	private Talon mockRightTalon;
	private Talon mockLeftTalon;
	
	
	@Before
	public void setUpDriveTrainRunnerTest(){		
		runner = new ArmRunner();
		mockRightTalon = mock(Talon.class);
		mockLeftTalon = mock(Talon.class);
		
		runnerSpy = spy(runner);
		doReturn(mockRightTalon).when(runnerSpy).getRightTalon();
		doReturn(mockLeftTalon).when(runnerSpy).getLeftTalon();
	}
	
	@Test
	public void positivePositiveArmTest(){
		ArmData.getInstance().setUpperSpeed(.5);
		ArmData.getInstance().setLowerSpeed(1.5);
		
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.5);
		verify(mockLeftTalon,times(1)).set(1.0);
	}

}

