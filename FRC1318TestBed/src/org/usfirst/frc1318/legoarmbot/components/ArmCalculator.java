package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.legoarmbot.calculators.TwoLinkArm;
import org.usfirst.frc1318.legoarmbot.shared.*;

public class ArmCalculator extends RobotComponentBase{

	private TwoLinkArm jCalculator;

	
	public void robotInIt() {
		jCalculator = new TwoLinkArm();
	}
	
	public void teleopPeriodic() {
		
		//right joystick is rate control, left joystick is position control 
		//TODO: change to one joystick with a button
		//TODO: get rid of news in teleopPeriodic 
		
		if(ReferenceData.getInstance().getUserInputData().isRightJoyStickActive()) {
			DeltaPoint movement = new DeltaPoint(ReferenceData.getInstance().getUserInputData().getDeltaX(), ReferenceData.getInstance().getUserInputData().getDeltaY());
			Configuration nextConfiguration = jCalculator.numericalInverseKinematics(ReferenceData.getInstance().getArmData().getCurrentConfiguration(), movement);
			ReferenceData.getInstance().getArmData().setTheta1PositionSetPoint(nextConfiguration.getTheta1());
			ReferenceData.getInstance().getArmData().setTheta2PositionSetPoint(nextConfiguration.getTheta2());
		} else {
			Point desiredPoint = new Point(ReferenceData.getInstance().getUserInputData().getClosedFormX(), ReferenceData.getInstance().getUserInputData().getClosedFormY());
			Configuration nextConfiguration = jCalculator.closedFormInverseKinematics(ReferenceData.getInstance().getArmData().getCurrentConfiguration(), desiredPoint);
			ReferenceData.getInstance().getArmData().setTheta1PositionSetPoint(nextConfiguration.getTheta1());
			ReferenceData.getInstance().getArmData().setTheta2PositionSetPoint(nextConfiguration.getTheta2());
		}
	}
	
	
}
