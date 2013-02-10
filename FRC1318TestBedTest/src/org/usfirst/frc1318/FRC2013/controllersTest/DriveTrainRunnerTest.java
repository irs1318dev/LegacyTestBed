package org.usfirst.frc1318.FRC2013.controllersTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.usfirst.frc1318.FRC2013.components.DriveTrainRunner;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import edu.wpi.first.wpilibj.Talon;
import static org.mockito.Mockito.*;

import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrainRunnerTest {
	
	DriveTrainRunner runner;
	DriveTrainRunner runnerSpy;
	Talon mockRightTalon;
	Talon mockLeftTalon;
	
	@Before
	public void setUpDriveTrainRunnerTest(){		
		runner = new DriveTrainRunner();
		mockRightTalon = mock(Talon.class);
		mockLeftTalon = mock(Talon.class);
		
		runnerSpy = spy(runner);
		doReturn(mockRightTalon).when(runnerSpy).getRightTalon();
		doReturn(mockLeftTalon).when(runnerSpy).getLeftTalon();
	}
	
	@Test
	public void right0Test(){
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(0.0);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(0.0);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.0);
		verify(mockLeftTalon,times(1)).set(0.0);
	}
	
	@Test
	public void rightPositive1Test(){
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(1);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(0.0);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(1);
		verify(mockLeftTalon,times(1)).set(0.0);
	}
	
	@Test
	public void rightNegitive1Test(){
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(-1);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(0.0);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(-1);
		verify(mockLeftTalon,times(1)).set(0.0);
	}
	
	@Test
	public void positiveInBoundsTest(){
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(.178);
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(.573);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(.573);
		verify(mockLeftTalon,times(1)).set(.178);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void left0Test(){
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(0.0);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(0.0);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.0);
		verify(mockLeftTalon,times(1)).set(0.0);
	}
	
	@Test
	public void leftPositive1Test(){
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(0.0);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(1);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.0);
		verify(mockLeftTalon,times(1)).set(1);
	}
	
	@Test
	public void leftNegitive1Test(){
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(0.0);
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(-1);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.0);
		verify(mockLeftTalon,times(1)).set(-1);
	}
	
	@Test
	public void negitiveInBoundsTest(){
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(-.178);
		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(-.573);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(-.573);
		verify(mockLeftTalon,times(1)).set(-.178);
	}
	
}
