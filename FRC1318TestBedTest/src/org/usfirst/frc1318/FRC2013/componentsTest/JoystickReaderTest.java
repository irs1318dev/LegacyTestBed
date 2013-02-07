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
	public void leftAssignPositive1Test(){
		setJoystickL(1);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickL(), 0.001);
	}
	
	@Test
	public void leftAssign0Test(){
		setJoystickL(0);
		joystickReader.robotTeleop();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickL(), 0.001);
	}
	
	@Test
	public void leftAssignNegitive1Test(){
		setJoystickL(-1);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickL(), 0.001);
	}
	
	@Test
	public void leftAssignPositive100Test(){
		setJoystickL(100);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickL(), 0.001);
	}
	
	@Test
	public void leftAssignNegitive100Test(){
		setJoystickL(-100);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickL(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightAssignPositive1Test(){
		setJoystickR(1);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickR(), 0.001);
	}
	
	@Test
	public void rightAssign0Test(){
		setJoystickR(0);
		joystickReader.robotTeleop();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickR(), 0.001);
	}
	
	@Test
	public void rightAssignNegitive1Test(){
		setJoystickR(-1);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickR(), 0.001);
	}
	
	@Test
	public void rightAssignPositive100Test(){
		setJoystickR(100);
		joystickReader.robotTeleop();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickR(), 0.001);
	}
	
	@Test
	public void rightAssignNegitive100Test(){
		setJoystickR(-100);
		joystickReader.robotTeleop();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickR(), 0.001);
	}
	
	private void setJoystickL(double val){
		when(mockJoystickL.getY()).thenReturn(val);
	}
	
	private void setJoystickR(double val){
		when(mockJoystickR.getY()).thenReturn(val);
	}
}
