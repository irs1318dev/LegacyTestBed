package org.usfirst.frc1318.FRC2013.componentsTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc1318.FRC2013.readers.Joystick1Reader;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JoystickReaderTest {
	
	Joystick mockJoystickL;
	Joystick mockJoystickR;
	Joystick1Reader joystickReader;
	
	//when(mockTimer.get()).thenReturn(time);
	
	@Before
	public void setUpJoystickReaderTest(){
		mockJoystickL = mock(Joystick.class);
		mockJoystickR = mock(Joystick.class);
		joystickReader = new Joystick1Reader();
		joystickReader.setJoystick(mockJoystickL, mockJoystickR);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void leftYAssignPositive1Test(){
		setJoystickLY(1);
		joystickReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignPositiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignPositiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssign0Test(){
		setJoystickLY(0);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitive1Test(){
		setJoystickLY(-1);
		joystickReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void leftXAssignPositive1Test(){
		setJoystickLX(1);
		joystickReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssignPositiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftXAssignPositiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftXAssign0Test(){
		setJoystickLY(0);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitive1Test(){
		setJoystickLX(-1);
		joystickReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightYAssignPositive1Test(){
		setJoystickRY(1);
		joystickReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignPositiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightYAssignPositiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightYAssign0Test(){
		setJoystickRY(0);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitive1Test(){
		setJoystickRY(-1);
		joystickReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightXAssignPositive1Test(){
		setJoystickRX(1);
		joystickReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignPositiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightXAssignPositiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightXAssign0Test(){
		setJoystickRX(0);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignNegitiveInBounds(){
		setJoystickLY(.42);
		joystickReader.teleopPeriodic();
		assertEquals(.355, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void rightXAssignNegitiveInDeadZone(){
		setJoystickLY(.06);
		joystickReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	
	@Test
	public void rightXAssignNegitive1Test(){
		setJoystickRX(-1);
		joystickReader.teleopPeriodic();
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
