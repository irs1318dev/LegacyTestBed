package org.usfirst.frc1318.FRC2013.readers;

import org.usfirst.frc1318.FRC2013.reference.GamePad1Ref;
import org.usfirst.frc1318.FRC2013.reference.Joystick2Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.DeadBand;
import org.usfirst.frc1318.generic.reference.GamePad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Joystick2Reader extends RobotComponentBase{
	
	private Joystick joystickL;
	private Joystick joystickR;
	
	public void robotInit(){
		joystickL = new Joystick(PortRef.JOYSTICK_L);
		joystickR = new Joystick(PortRef.JOYSTICK_R);
	}
	
	public void teleopPeriodic(){
		ReferenceData.getInstance().getUserInputData().setLiftUp(joystickL.getRawButton(Joystick2Ref.LIFT_UP));
		ReferenceData.getInstance().getUserInputData().setLiftDown(joystickL.getRawButton(Joystick2Ref.LIFT_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterUp(joystickL.getRawButton(Joystick2Ref.SHOOTER_UP));
		ReferenceData.getInstance().getUserInputData().setShooterDown(joystickL.getRawButton(Joystick2Ref.SHOOTER_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(joystickL.getRawButton(Joystick2Ref.SHOOTER_SPEED_UP));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(joystickL.getRawButton(Joystick2Ref.SHOOTER_SPEED_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterFire((joystickL.getRawButton(Joystick2Ref.SHOOTER_FIRE)));
		
		double initialJYL = joystickL.getY(Hand.kLeft);
		double jYL= DeadBand.applyLinearDeadBand(initialJYL,0.1);
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(jYL);
		double initialJYR = joystickL.getY(Hand.kRight);
		double jYR= DeadBand.applyLinearDeadBand(initialJYR,0.1);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(jYR);
		System.out.println("intiialJYL= "+initialJYL+",jyL="+ReferenceData.getInstance().getUserInputData().getJoystickLeft()
				+", initialJYR="+initialJYR+" ,jyR= " + ReferenceData.getInstance().getUserInputData().getJoystickRight());

	}
}
