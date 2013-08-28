package org.usfirst.frc1318.legoarmbot.components;

import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.legoarmbot.calculators.TwoLinkArm;
import org.usfirst.frc1318.legoarmbot.shared.*;

public class ArmCalculator extends RobotComponentBase{

	TwoLinkArm jCalculator;
	
	public void robotInIt() {
		jCalculator = new TwoLinkArm();
	}
	
	public void teleopPeriodic() {
		DeltaPoint movement = new DeltaPoint(ReferenceData.getInstance().getUserInputData().getDeltaX(), ReferenceData.getInstance().getUserInputData().getDeltaY());
		Configuration nextConfiguration = jCalculator.numericalInverseKinematics(ReferenceData.getInstance().getArmData().getCurrentConfiguration(), movement);
		ReferenceData.getInstance().getArmData().setTheta1PositionSetPoint(nextConfiguration.getTheta1());
		ReferenceData.getInstance().getArmData().setTheta2PositionSetPoint(nextConfiguration.getTheta2());
	}
	
	
}
