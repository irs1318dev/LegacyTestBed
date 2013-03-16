package org.usfirst.frc1318.autonomous.macros;

//Assumes prior motor speed by driver preference.

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.*;

public class AutonomousEllensburgMiddle extends AutonomousMode implements AutoTask{
	
	private static final double SHOOTER_SPEED = -0.950;

	public void run() {
		System.out.println("*******************************************AutonomousEllensburgCenter currentState: " + currentState);
//		System.out.println("***********DriveTrain ticks: " + driveEncTicks); 
		switch(currentState){
			case 0:
				andWait(3500);
				System.out.println("*******************1");
				break;
			case 1:
				shooterUp();
				System.out.println("*******************2");
				break;
			case 2://spin up shooter
				spinShooter(SHOOTER_SPEED);
				System.out.println("*******************3");
				break;
			case 3:
				andWait(500);
				System.out.println("*******************4");
				break;
			case 4://fire
				fire();
				System.out.println("*******************5");
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
