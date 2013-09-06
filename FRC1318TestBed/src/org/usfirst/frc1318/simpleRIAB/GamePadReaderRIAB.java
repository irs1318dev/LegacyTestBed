package org.usfirst.frc1318.simpleRIAB;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;

public class GamePadReaderRIAB extends RobotComponentBase{
	
	GamePad gamePad;
	
	public void robotInit(){
		gamePad = GamePad.create(PortRef.GAME_PAD);
	}
	
	int debugCount=0;
	
	public void teleopPeriodic(){
		double yleft=gamePad.getYLeft();
		if (debugCount%100==0) {
	    	System.out.println("GamePadReaderRIAB.teleopPeriodic() yleft="+yleft);
		}
		GamePadData.getInstance().setYValue(yleft);
	}

}
