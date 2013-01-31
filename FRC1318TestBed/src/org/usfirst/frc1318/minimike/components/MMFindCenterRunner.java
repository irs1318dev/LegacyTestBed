package org.usfirst.frc1318.minimike.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.minimike.calculators.MMCalculator;
import org.usfirst.frc1318.minimike.shared.MMTurretData;

public class MMFindCenterRunner extends RobotComponentBase {
	
	private static final double ROBOT_SPEED = 1;	//TODO moves right
	MMTurretData turretData;
	MMCalculator calculator;
	private int lastHit = 0;
	private long startTime = 0;
	private long endTime = 0;
	private long time = 0;
	private long timeSpent = 0;
	
	public MMFindCenterRunner(){
	}
	
	public void robotInit() {
		turretData = new MMTurretData();
		calculator = new MMCalculator();
	}
	
	public void teleopInit(){
		if(calculator.canMoveRight() && lastHit == 0){
			turretData.setTurnSpeed(ROBOT_SPEED);
		}else if(!calculator.canMoveRight() && lastHit == 0){
			lastHit = 1;
			startTime = System.currentTimeMillis();
		}else if(calculator.canMoveLeft() && lastHit == 1){
			turretData.setTurnSpeed(-(ROBOT_SPEED));
		}else if(!calculator.canMoveLeft() && lastHit == 1){
			lastHit = 2;
			endTime = System.currentTimeMillis();
		}else if(lastHit == 2){
			lastHit = 3;
			time = (startTime - endTime) / 2;
		}else if(lastHit == 3 && timeSpent < time){
			turretData.setTurnSpeed(ROBOT_SPEED);
			timeSpent += System.currentTimeMillis() - endTime;
		} 
	} 
}
