package org.usfirst.frc1318.FRC2013.readers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc1318.FRC2013.reference.Joystick1Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

public class Joystick1Reader extends RobotComponentBase {
	Joystick joystick;
	
	public void robotInit() {
		joystick = new Joystick(PortRef.JOYSTICK_R);
	}

	public void teleopPeriodic() {
		ReferenceData.getInstance().getUserInputData().setLiftUp(joystick.getRawButton(Joystick1Ref.LIFT_UP));
		ReferenceData.getInstance().getUserInputData().setLiftDown(joystick.getRawButton(Joystick1Ref.LIFT_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterUp(joystick.getRawButton(Joystick1Ref.SHOOTER_UP));
		ReferenceData.getInstance().getUserInputData().setShooterDown(joystick.getRawButton(Joystick1Ref.SHOOTER_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(joystick.getRawButton(Joystick1Ref.SHOOTER_SPEED_UP));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(joystick.getRawButton(Joystick1Ref.SHOOTER_SPEED_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterFire((joystick.getRawButton(Joystick1Ref.SHOOTER_FIRE)));
		
		ReferenceData.getInstance().getUserInputData().setJoystickY(joystick.getY(Hand.kLeft));
		ReferenceData.getInstance().getUserInputData().setJoystickX(joystick.getX(Hand.kLeft));
	}
}