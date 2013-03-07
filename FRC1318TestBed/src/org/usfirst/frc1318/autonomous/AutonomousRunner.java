package org.usfirst.frc1318.autonomous;

import org.usfirst.frc1318.FRC2013.reference.DipSwitchRef;
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
			if (ReferenceData.getInstance().getDipSwitchData().getDipSwitch(DipSwitchRef.DIP_SWITCH_R) && ReferenceData.getInstance().getDipSwitchData().getDipSwitch(DipSwitchRef.DIP_SWITCH_L)) {
				System.out.println("Switch 2 on && switch 1 on - center");
				this.task = new AutonomousCenter();
			} else if (ReferenceData.getInstance().getDipSwitchData().getDipSwitch(DipSwitchRef.DIP_SWITCH_R)) {
				System.out.println("Switch 2 on && switch 1 off - right");
				this.task = new AutonomousRight();
			} else if (ReferenceData.getInstance().getDipSwitchData().getDipSwitch(DipSwitchRef.DIP_SWITCH_L)) {
				System.out.println("Switch 2 off && switch 1 on - left");
				this.task = new AutonomousLeft();
			} else {
				System.out.println("Switch 2 off && switch 1 off - center");
				this.task = new AutonomousCenter();
			}
		}

		
		if(task != null) {
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
