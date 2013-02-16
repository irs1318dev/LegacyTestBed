package org.usfirst.frc1318.FRC2013.readers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc1318.FRC2013.reference.Joystick1Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;

public class Joystick1Reader extends RobotComponentBase {
	Joystick joystickL;
	Joystick joystickR;
	
	public void robotInit() {
		joystickR = new Joystick(PortRef.JOYSTICK_R);
		joystickL = new Joystick(PortRef.JOYSTICK_L);
	}

	public void teleopPeriodic() {
		ReferenceData.getInstance().getUserInputData().setLiftUp(joystickR.getRawButton(Joystick1Ref.LIFT_UP));
		ReferenceData.getInstance().getUserInputData().setLiftDown(joystickR.getRawButton(Joystick1Ref.LIFT_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterUp(joystickR.getRawButton(Joystick1Ref.SHOOTER_UP));
		ReferenceData.getInstance().getUserInputData().setShooterDown(joystickR.getRawButton(Joystick1Ref.SHOOTER_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(joystickR.getRawButton(Joystick1Ref.SHOOTER_SPEED_UP));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(joystickR.getRawButton(Joystick1Ref.SHOOTER_SPEED_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterFire((joystickR.getRawButton(Joystick1Ref.SHOOTER_FIRE)));
		
		double joystickX = joystickR.getX();
		double joystickY = -joystickR.getY();
		if(Math.abs(joystickX)<0.1){
			joystickX = joystickL.getX()/4;
		}
		if(Math.abs(joystickY)<0.1){
			joystickY = joystickL.getY()/4;
		}
		ReferenceData.getInstance().getUserInputData().setJoystickX(joystickX);
		ReferenceData.getInstance().getUserInputData().setJoystickY(joystickY);
	}
}