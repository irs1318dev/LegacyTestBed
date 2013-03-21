package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.*;

public class AutonomousEllensburgSide extends AutonomousMode implements AutoTask {

	private static final double SHOOTER_SPEED = -0.920;
	
	public void run() {
		System.out.println("*******************************************AutotonomousEllensburgSide currentState: " + currentState);
		switch(currentState){
			case 0:
				andWait(3500);
				break;
			case 1:
				shooterUp();
				break;
			case 2:
				spinShooterDirectly(SHOOTER_SPEED);
				break;
			case 3:
				andWait(2000);
				break;
			case 4: 
				fire();
				break;
			default:
				hasFinished = true;
				break;
		}
	}
	
	public void fire(){
		if(discsFired<3){
			if(System.currentTimeMillis() - startTime > 1250 && System.currentTimeMillis() - startTime < 1500) {
				System.out.println("*******Firing");
				ReferenceData.getInstance().getUserInputData().setShooterFire(true);
			} else if (System.currentTimeMillis() - startTime > 1500) {
				System.out.println("*******Waiting for next fire");
				startTime = System.currentTimeMillis();
				discsFired++;
			}
		}
		else{
			nextState();
		}
	}
	
	public void cancel() {
		ReferenceData.getInstance().getUserInputData().setShooterFire(false);
	}
}
