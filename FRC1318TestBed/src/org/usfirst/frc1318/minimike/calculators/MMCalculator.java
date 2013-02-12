package org.usfirst.frc1318.minimike.calculators;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.utils.DriverStationPrint;
import org.usfirst.frc1318.minimike.shared.MMReferenceData;

public class MMCalculator extends RobotComponentBase {
	
	DriverStationPrint driverStationPrint;
	
	public static final double SPEED = 0.25;
	
	public MMCalculator(){
	}
	
	public void robotInit(){
		driverStationPrint = new DriverStationPrint();
	}
	
	public void teleopPeriodic(){
//		System.out.println(
//				"RightButton: " + MMGamePadData.getInstance().getRightButton()
//				+ ", LeftButton: " + MMGamePadData.getInstance().getLeftButton()
//				+  ", CanMoveRight: "+ canMoveRight() 
//				+ ", CanMoveLeft: "+ canMoveLeft());
		
		if (MMReferenceData.getInstance().getMMGamePadData().getRightButton() && canMoveLeft()){
			//System.out.println("moving right");
			MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(SPEED);
		} else if (MMReferenceData.getInstance().getMMGamePadData().getLeftButton() && canMoveRight()){
			//System.out.println("moving left");
			MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(-SPEED);
		} else {
			MMReferenceData.getInstance().getMMTurretData().setTurnSpeed(0);
		}
	}
	
//	private boolean canMove(){
//		if(MMLimitSwitchData.getInstance().getLeftState() && MMLimitSwitchData.getInstance().getRightState()){
//			return false;
//		}
//		return true;
//	}

	//TODO move to a data class.
	private boolean canMoveRight(){
		if(MMReferenceData.getInstance().getMMLimitSwitchData().getRightState()){
			return false;
		}
		return true;
	}
	
	private boolean canMoveLeft(){
		if(MMReferenceData.getInstance().getMMLimitSwitchData().getLeftState()){
			return false;
		}
		return true;
	}
	
}
