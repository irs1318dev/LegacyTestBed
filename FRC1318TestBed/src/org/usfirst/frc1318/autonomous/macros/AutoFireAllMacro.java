package org.usfirst.frc1318.autonomous.macros;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.AutoTask;
import org.usfirst.frc1318.autonomous.AutonomousMode;

public class AutoFireAllMacro extends AutonomousMode implements AutoTask{

	public void run() {
		System.out.println("*******************************************AutoFireAllMacro currentState: " + currentState);
//		System.out.println("***********DriveTrain ticks: " + driveEncTicks); 
		switch(currentState){
			case 0:
				fire();
				System.out.println("*******************1");
				break;
			default:
				hasFinished = true;
				break;
		}
	}

	public void cancel() {
		
	}
	
	public void fire(){
		if(discsFired<4){
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

}
