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
	
//	class TestTalon extends SpeedController{
//
//		public TestTalon(int channel) {
//			super();
//		}
//		double speed;
//		
//		public void set(double val){
//			speed = val;
//		}
//		public double get(){
//			return speed;
//		}
//		
//	}
	
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
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.0);
		verify(mockLeftTalon,times(1)).set(0.0);
	}
	
//	@Test
//	public void rightPositive1Test(){
//		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(1);
//		runner.teleopPeriodic();
//		assertEquals(1, mockRightTalon.get(), .001);
//	}
//	
//	@Test
//	public void rightNegitive1Test(){
//		System.out.println("right -1");
//		ReferenceData.getInstance().getDriveTrainData().setRightPIDSpeed(-1);
//		runner.teleopPeriodic();
//		assertEquals(-1, mockRightTalon.get(), .001);
//	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void left0Test(){
		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(0.0);
		runnerSpy.teleopPeriodic();
		verify(mockRightTalon,times(1)).set(0.0);
		verify(mockLeftTalon,times(1)).set(0.0);
	}
	
//	@Test
//	public void leftPositive1Test(){
//		System.out.println("left 1");
//		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(1);
//		runner.teleopPeriodic();
//		assertEquals(1, mockLeftTalon.get(), .001);
//	}
//	
//	@Test
//	public void leftNegitive1Test(){
//		System.out.println("left -1");
//		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(-1);
//		runner.teleopPeriodic();
//		System.out.println("DriveTrainRunnerTest 88 " + mockLeftTalon.get());
//		assertEquals(-1, mockLeftTalon.get(), .001);
//	}
//	
//	@Test
//	public void leftNegitiveInBoundsTest(){
//		System.out.println("left -.178");
//		ReferenceData.getInstance().getDriveTrainData().setLeftPIDSpeed(-.178);
//		runner.teleopPeriodic();
//		//System.out.println("DriveTrainRunnerTest 96 mockLeftTalon.get() =  " + mockLeftTalon.get() +
//		//				   "\nDriveTrainRunnerTest 97 mockLeftTalon.getSpeed() = " + mockLeftTalon.getSpeed());
//		assertEquals(-.178, mockLeftTalon.get(), .001);
//	}
	
}
