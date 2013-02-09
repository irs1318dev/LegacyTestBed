package org.usfirst.frc1318.FRC2013.componentsTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.usfirst.frc1318.FRC2013.controllers.DriveTrainEncoderReader;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.generic.sensors.EncoderAngularVelocity;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DriveTrainEncoderReaderTest {
	
	DriveTrainEncoderReader reader;
	EncoderAngularVelocity mockEncoderR;
	EncoderAngularVelocity mockEncoderL;
	
	@Before
	public void setUpDriveTrainEncoderReaderTest(){
		reader = new DriveTrainEncoderReader();
		mockEncoderL = mock(EncoderAngularVelocity.class);
		mockEncoderR = mock(EncoderAngularVelocity.class);
		reader.setEncoders(mockEncoderR, mockEncoderL);
	}
	
	@Test
	public void left0Test(){
		setEncoderL(0);
		reader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder(), .001);
	}
	
	@Test
	public void leftPositive1Test(){
		setEncoderL(1);
		reader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder(), .001);
	}
	
	@Test
	public void leftPositive1HalfTest(){
		setEncoderL(.5);
		reader.teleopPeriodic();
		assertEquals(.5, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder(), .001);
	}
	
	@Test
	public void leftNegitive1Test(){
		setEncoderL(-1);
		reader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder(), .001);
	}
	
	@Test
	public void leftNegitive1HalfTest(){
		setEncoderL(-.5);
		reader.teleopPeriodic();
		assertEquals(-.5, ReferenceData.getInstance().getDriveTrainData().getLeftEncoder(), .001);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void right0Test(){
		setEncoderR(0);
		reader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getDriveTrainData().getRightEncoder(), .001);
	}
	
	@Test
	public void rightPositive1Test(){
		setEncoderR(1);
		reader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getDriveTrainData().getRightEncoder(), .001);
	}
	
	@Test
	public void rightPositive1HalfTest(){
		setEncoderR(.5);
		reader.teleopPeriodic();
		assertEquals(.5, ReferenceData.getInstance().getDriveTrainData().getRightEncoder(), .001);
	}
	
	@Test
	public void rightNegitive1Test(){
		setEncoderR(-1);
		reader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getDriveTrainData().getRightEncoder(), .001);
	}
	
	@Test
	public void rightNegitive1HalfTest(){
		setEncoderR(-.5);
		reader.teleopPeriodic();
		assertEquals(-.5, ReferenceData.getInstance().getDriveTrainData().getRightEncoder(), .001);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void setEncoderR(double val){
		when(mockEncoderR.getValue()).thenReturn(val);
	}
	
	private void setEncoderL(double val){
		when(mockEncoderL.getValue()).thenReturn(val);
	}
	
}
