package org.usfirst.frc1318.FRC2013.readers;

import org.usfirst.frc1318.FRC2013.reference.GamePad1Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.reference.GamePad;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class GamePad2Reader extends RobotComponentBase{
	
	private GamePad gamePad;
	
	private Joystick joystick;
	
	public void robotInit(){
		gamePad = GamePad.create(PortRef.GAMEPAD);
		joystick = new Joystick(PortRef.JOYSTICK_L);
	}
	
	public void teleopPeriodic(){
		ReferenceData.getInstance().getUserInputData().setLiftUp(gamePad.getRawButton(GamePad1Ref.LIFT_UP));
		ReferenceData.getInstance().getUserInputData().setLiftDown(gamePad.getRawButton(GamePad1Ref.LIFT_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterUp(gamePad.getRawButton(GamePad1Ref.SHOOTER_UP));
		ReferenceData.getInstance().getUserInputData().setShooterDown(gamePad.getRawButton(GamePad1Ref.SHOOTER_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(gamePad.getRawButton(GamePad1Ref.SHOOTER_SPEED_UP));
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(gamePad.getRawButton(GamePad1Ref.SHOOTER_SPEED_DOWN));
		ReferenceData.getInstance().getUserInputData().setShooterFire((gamePad.getRawButton(GamePad1Ref.SHOOTER_FIRE)));
		
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(joystick.getY(Hand.kLeft));
		ReferenceData.getInstance().getUserInputData().setJoystickRight(joystick.getY(Hand.kRight));
	}

}
