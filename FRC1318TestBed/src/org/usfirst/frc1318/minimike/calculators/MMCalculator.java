package org.usfirst.frc1318.minimike.calculators;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.shared.MMGamePadData;
import org.usfirst.frc1318.minimike.shared.MMLimitSwitchData;
import org.usfirst.frc1318.shared.minimike.MMTurretData;
import org.usfirst.frc1318.utils.DriverStationPrint;

public class MMCalculator extends RobotComponentBase {
	
	DriverStationPrint driverStationPrint;
	
	public static final double SPEED = 1;
	
	public MMCalculator(){
	}
	
	public void robotInit(){
		driverStationPrint = new DriverStationPrint();
	}
	
	public void teleopPeriodic(){
		if(MMGamePadData.getInstance().getRightButton() && canMoveRight()){
			MMTurretData.setTurnSpeed(SPEED);
		}else if(MMGamePadData.getInstance().getLeftButton() && canMoveLeft()){
			MMTurretData.setTurnSpeed(-SPEED);
		}else{
			MMTurretData.setTurnSpeed(0);
		}
	}
	
	public static boolean canMove(){
		if(MMLimitSwitchData.getInstance().getLeftState() && MMLimitSwitchData.getInstance().getRightState()){
			return false;
		}
		return true;
	}
	
	public static boolean canMoveRight(){
		if(MMLimitSwitchData.getInstance().getRightState() && canMove()){
			return false;
		}
		return true;
	}
	
	public static boolean canMoveLeft(){
		if(MMLimitSwitchData.getInstance().getLeftState() && canMove()){
			return false;
		}
		return true;
	}
	
}
