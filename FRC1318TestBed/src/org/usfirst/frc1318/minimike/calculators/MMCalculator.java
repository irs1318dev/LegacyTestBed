package org.usfirst.frc1318.minimike.calculators;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.shared.MMGamePadData;
import org.usfirst.frc1318.minimike.shared.MMLimitSwitchData;
import org.usfirst.frc1318.minimike.shared.MMTurretData;
import org.usfirst.frc1318.utils.DriverStationPrint;

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
		
		if (MMGamePadData.getInstance().getRightButton() && canMoveLeft()){
			//System.out.println("moving right");
			MMTurretData.getInstance().setTurnSpeed(SPEED);
		} else if (MMGamePadData.getInstance().getLeftButton() && canMoveRight()){
			//System.out.println("moving left");
			MMTurretData.getInstance().setTurnSpeed(-SPEED);
		} else {
			MMTurretData.getInstance().setTurnSpeed(0);
		}
	}
	
//	private boolean canMove(){
//		if(MMLimitSwitchData.getInstance().getLeftState() && MMLimitSwitchData.getInstance().getRightState()){
//			return false;
//		}
//		return true;
//	}
	
	private boolean canMoveRight(){
		if(MMLimitSwitchData.getInstance().getRightState()){
			return false;
		}
		return true;
	}
	
	private boolean canMoveLeft(){
		if(MMLimitSwitchData.getInstance().getLeftState()){
			return false;
		}
		return true;
	}
	
}
