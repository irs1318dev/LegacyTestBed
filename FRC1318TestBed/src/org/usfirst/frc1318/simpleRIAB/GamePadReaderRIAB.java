package org.usfirst.frc1318.simpleRIAB;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;

public class GamePadReaderRIAB extends RobotComponentBase{
	
	GamePad gamePad;
	
	public void robotInit(){
		gamePad = GamePad.create(PortRef.GAME_PAD);
	}
	
	public void teleopPeriodic(){
		GamePadData.getInstance().setYValue(gamePad.getYLeft());
	}

}
