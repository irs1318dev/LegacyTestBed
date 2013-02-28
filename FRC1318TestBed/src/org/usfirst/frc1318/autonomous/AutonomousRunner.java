package org.usfirst.frc1318.autonomous;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.autonomous.macros.*;
import org.usfirst.frc1318.components.RobotComponentBase;

public class AutonomousRunner extends RobotComponentBase {
	private AutoTask task;
	
	public void disabledInit() {
		// when we disable, clear the AutoTask
		task = null;
	}
	
	public void autonomousPeriodic() {
		if (task == null) {
			System.out.println("No task - Checking dipswitch...");
			if (ReferenceData.getInstance().getDipSwitchData().getDipSwitch(8)) {
				System.out.println("Switch 8 on - firing");
				this.task = new AutoFireAll();
			} else {
				System.out.println("Switch 8 off - driving");
				this.task = new AutoDriveShootMacro();
			}
		}
		
		if(task != null) {
			System.out.println("Have an autonomous task");
			if (!task.hasInitalized()) {
				System.out.println("Autonomous init");
				task.init();
			} else if(!task.hasFinished()) {
				System.out.println("Running Autonomous...");
				task.run();
			} 
		}
	}
}
