package org.usfirst.frc1318.autonomous;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.usfirst.frc1318.autonomous.AutoRunner;
import org.usfirst.frc1318.autonomous.AutoMacroMap;


public class AutonomousRunnerTest 
{
	AutoRunner autoRunner;
	AutoMacroMap macroMap;
	
	@Before
	public void setUpAutoRunnerTest()
	{
		autoRunner = mock(AutoRunner.class);
		macroMap = new AutoMacroMap(autoRunner);
		macroMap.FAKE_BUTTON_1_isDown = false;
		macroMap.FAKE_BUTTON_2_isDown = true;
		autoRunner.macroMap = macroMap;
	}
}
