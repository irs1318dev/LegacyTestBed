package org.usfirst.frc1318.FRC2013.componentsTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc1318.FRC2013.controllers.JoystickReader;
import org.usfirst.frc1318.FRC2013.shared.JoystickData;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JoystickReaderTest {
	
	Joystick mockJoystickL;
	Joystick mockJoystickR;
	JoystickReader joystickReader;
	
	//when(mockTimer.get()).thenReturn(time);
	
	@Before
	public void setUpJoystickReaderTest(){
		mockJoystickL = mock(Joystick.class);
		mockJoystickR = mock(Joystick.class);
		joystickReader = new JoystickReader();
		joystickReader.setJoystick(mockJoystickL, mockJoystickR);
	}
	
	@Test
	public void leftYAssignPositive1Test(){
		setJoystickLY(1);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssign0Test(){
		setJoystickLY(0);
		joystickReader.robotTeleop();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitive1Test(){
		setJoystickLY(-1);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignPositive100Test(){
		setJoystickLY(100);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitive100Test(){
		setJoystickLY(-100);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void leftXAssignPositive1Test(){
		setJoystickLX(1);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssign0Test(){
		setJoystickLY(0);
		joystickReader.robotTeleop();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitive1Test(){
		setJoystickLX(-1);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssignPositive100Test(){
		setJoystickLX(100);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitive100Test(){
		setJoystickLX(-100);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightYAssignPositive1Test(){
		setJoystickRY(1);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssign0Test(){
		setJoystickRY(0);
		joystickReader.robotTeleop();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitive1Test(){
		setJoystickRY(-1);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignPositive100Test(){
		setJoystickRY(100);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitive100Test(){
		setJoystickRY(-100);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightXAssignPositive1Test(){
		setJoystickRX(1);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssign0Test(){
		setJoystickRX(0);
		joystickReader.robotTeleop();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignNegitive1Test(){
		setJoystickRX(-1);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignPositive100Test(){
		setJoystickRX(100);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignNegitive100Test(){
		setJoystickRX(-100);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void setJoystickLY(double val){
		when(mockJoystickL.getY()).thenReturn(val);
	}
	
	private void setJoystickRY(double val){
		when(mockJoystickR.getY()).thenReturn(val);
	}
	
	private void setJoystickLX(double val){
		when(mockJoystickL.getX()).thenReturn(val);
	}
	
	private void setJoystickRX(double val){
		when(mockJoystickR.getX()).thenReturn(val);
	}
}
