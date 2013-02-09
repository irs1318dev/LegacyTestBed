package org.usfirst.frc1318.FRC2013.componentsTest;

import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc1318.FRC2013.controllers.LifterLimitSwitchReader;
import org.usfirst.frc1318.FRC2013.shared.LifterLimitSwitchData;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import static org.mockito.Mockito.*;

import edu.wpi.first.wpilibj.DigitalInput;

public class LifterLimitSwitchReaderTest {
	DigitalInput mockLifterLimitSwitch;
	LifterLimitSwitchReader lifterLimitSwitchReader;
	LifterLimitSwitchReader lifterLimitSwitchReaderSpy;
	LifterLimitSwitchData mockLifterLimitSwtichData;
	
	@Before
	public void setUpLifterLimitSwitchReaderTest() {
		mockLifterLimitSwtichData = mock(LifterLimitSwitchData.class);
		ReferenceData.getInstance().setLifterLimitSwitchData(mockLifterLimitSwtichData);
		lifterLimitSwitchReader = new LifterLimitSwitchReader();
		mockLifterLimitSwitch = mock(DigitalInput.class);
		lifterLimitSwitchReaderSpy = spy(lifterLimitSwitchReader);
		doReturn(mockLifterLimitSwitch).when(lifterLimitSwitchReaderSpy).getLifterLimitSwitch();
	}
	
	@Test
	public void limitSwitchTrueTest() {
		when(mockLifterLimitSwitch.get()).thenReturn(true);
		lifterLimitSwitchReaderSpy.teleopPeriodic();
		verify(ReferenceData.getInstance().getLifterLimitSwitchData(),times(1)).setIsSwitched(true);
	}
	
	@Test
	public void limitSwitchFalseTest() {
		when(mockLifterLimitSwitch.get()).thenReturn(false);
		lifterLimitSwitchReaderSpy.teleopPeriodic();
		verify(ReferenceData.getInstance().getLifterLimitSwitchData(),times(1)).setIsSwitched(false);
	}
}
