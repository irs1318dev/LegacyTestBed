package org.usfirst.frc1318.FRC2013.readers;

import org.usfirst.frc1318.FRC2013.reference.GamePad1Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.JoystickFilter;
import org.usfirst.frc1318.generic.reference.GamePad;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;

public class GamePad1Reader extends RobotComponentBase{
	
	private GamePad gamePad;
	
	private Joystick joystick;
	
	private double joystickLeft;
	private double joystickRight;
	
	private double joystickX;
	private double joystickY;
	
	private boolean liftDown;
	private boolean liftUp;
	
	private boolean shooterDown;
	private boolean shooterUp;
	
	private boolean shooterSpeedUp;
	private boolean shooterSpeedDown;
	
	private boolean shooterFire;
	
	private boolean autoTranslateRight;
	private boolean autoLift;
	private boolean autoFireAll;
	private boolean autoTranslateLeft;
	private boolean autoDriveShoot;
	
	public void teleopPeriodic()
	{
		joystickY= - JoystickFilter.applyLinearDeadBand(joystick.getY(Hand.kRight),0.1);
		joystickX= JoystickFilter.applyLinearDeadBand(joystick.getX(Hand.kRight),0.1);
		
		
		liftUp = (gamePad.getRawButton(GamePad1Ref.LIFT_UP));
		liftDown = (gamePad.getRawButton(GamePad1Ref.LIFT_DOWN));
		shooterUp = (gamePad.getRawButton(GamePad1Ref.SHOOTER_UP));
		shooterDown = (gamePad.getRawButton(GamePad1Ref.SHOOTER_DOWN));
		shooterSpeedUp = (gamePad.getRawButton(GamePad1Ref.SHOOTER_SPEED_UP));
		shooterSpeedDown = (gamePad.getRawButton(GamePad1Ref.SHOOTER_SPEED_DOWN));
		shooterFire = ((gamePad.getRawButton(GamePad1Ref.SHOOTER_FIRE)));
		
		ReferenceData.getInstance().getUserInputData().setLiftUp(liftUp);
		ReferenceData.getInstance().getUserInputData().setLiftDown(liftDown);
		ReferenceData.getInstance().getUserInputData().setShooterUp(shooterUp);
		ReferenceData.getInstance().getUserInputData().setShooterDown(shooterDown);
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(shooterSpeedUp);
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(shooterSpeedDown);
		ReferenceData.getInstance().getUserInputData().setShooterFire(shooterFire);
		ReferenceData.getInstance().getUserInputData().setJoystickY(joystickY);
		ReferenceData.getInstance().getUserInputData().setJoystickX(joystickX);
	}
	
	public void robotInit(){
		gamePad = GamePad.create(PortRef.GAMEPAD);
		joystick = new Joystick(PortRef.JOYSTICK_L);
	}
}
