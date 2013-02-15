package org.usfirst.frc1318.FRC2013.componentsTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc1318.FRC2013.readers.GamePad1Reader;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.generic.reference.GamePad;

import edu.wpi.first.wpilibj.Joystick;

public class GamePadReaderTest {

	GamePad1Reader gamePadReader;
	GamePad gamePad;
	
	//when(mockTimer.get()).thenReturn(time);
	
	@Before
	public void setUpGamePadReaderTest(){
		gamePad = mock(GamePad.class);
		gamePadReader = new GamePad1Reader();
		gamePadReader.setGamePad(gamePad);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void leftYAssignPositive1Test(){
		setJoystickLY(1);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssign0Test(){
		setJoystickLY(0);
		gamePadReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitive1Test(){
		setJoystickLY(-1);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignPositive100Test(){
		setJoystickLY(100);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftYAssignNegitive100Test(){
		setJoystickLY(-100);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void leftXAssignPositive1Test(){
		setJoystickLX(1);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssign0Test(){
		setJoystickLY(0);
		gamePadReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickLY(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitive1Test(){
		setJoystickLX(-1);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssignPositive100Test(){
		setJoystickLX(100);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
	@Test
	public void leftXAssignNegitive100Test(){
		setJoystickLX(-100);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickLX(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightYAssignPositive1Test(){
		setJoystickRY(1);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssign0Test(){
		setJoystickRY(0);
		gamePadReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitive1Test(){
		setJoystickRY(-1);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignPositive100Test(){
		setJoystickRY(100);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
	@Test
	public void rightYAssignNegitive100Test(){
		setJoystickRY(-100);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRY(), 0.001);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void rightXAssignPositive1Test(){
		setJoystickRX(1);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssign0Test(){
		setJoystickRX(0);
		gamePadReader.teleopPeriodic();
		assertEquals(0, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignNegitive1Test(){
		setJoystickRX(-1);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignPositive100Test(){
		setJoystickRX(100);
		gamePadReader.teleopPeriodic();
		assertEquals(1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	@Test
	public void rightXAssignNegitive100Test(){
		setJoystickRX(-100);
		gamePadReader.teleopPeriodic();
		assertEquals(-1, ReferenceData.getInstance().getJoystickData().getJoystickRX(), 0.001);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void setJoystickLY(double val){
		when(gamePad.getYLeft()).thenReturn(val);
	}
	
	private void setJoystickRY(double val){
		when(gamePad.getYRight()).thenReturn(val);
	}
	
	private void setJoystickLX(double val){
		when(gamePad.getXLeft()).thenReturn(val);
	}
	
	private void setJoystickRX(double val){
		when(gamePad.getXRight()).thenReturn(val);
	}
}
