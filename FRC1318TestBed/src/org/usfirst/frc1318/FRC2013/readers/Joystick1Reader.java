package org.usfirst.frc1318.FRC2013.readers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import org.usfirst.frc1318.FRC2013.reference.GamePad1Ref;
import org.usfirst.frc1318.FRC2013.reference.Joystick1Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.JoystickFilter;

public class Joystick1Reader extends RobotComponentBase {
	Joystick joystickL;
	Joystick joystickR;
	
	private double joystickX;
	private double joystickY;
	
	private boolean liftDown;
	private boolean liftUp;
	
	private boolean shooterDown;
	private boolean shooterUp;
	
	private boolean shooterSpeedUp;
	private boolean shooterSpeedDown;
	
	private boolean shooterFire;
	
	private boolean shooterLifterDown;
	private boolean shooterLifterUp;
	
	
	private boolean autoTranslateRight;
	private boolean autoLift;
	private boolean autoFireAll;
	private boolean autoTranslateLeft;
	private boolean autoDriveShoot;
	
	private double joystickThrottle;
	
	private boolean[] anyUIArr = new boolean[15];
	
	public void robotInit() {
		joystickR = new Joystick(PortRef.JOYSTICK_R);
		joystickL = new Joystick(PortRef.JOYSTICK_L);
	}

	public void teleopPeriodic() {
		
		
		//Manual Tasks
		liftUp = (joystickL.getRawButton(Joystick1Ref.LIFT_UP));
		liftDown = (joystickL.getRawButton(Joystick1Ref.LIFT_DOWN));
		shooterUp = (joystickL.getRawButton(Joystick1Ref.SHOOTER_UP));
		shooterDown = (joystickL.getRawButton(Joystick1Ref.SHOOTER_DOWN));
		shooterSpeedUp = (joystickL.getRawButton(Joystick1Ref.SHOOTER_SPEED_UP));
		shooterSpeedDown = (joystickL.getRawButton(Joystick1Ref.SHOOTER_SPEED_DOWN));
		shooterFire = (joystickL.getRawButton(Joystick1Ref.SHOOTER_FIRE));
//		autoTranslateLeft = joystickR.getRawButton(Joystick1Ref.AUTO_TRANSLATE_LEFT);
//		autoFireAll = joystickR.getRawButton(Joystick1Ref.AUTO_FIREALL);
//		autoLift = joystickR.getRawButton(Joystick1Ref.AUTO_LIFT);
//		autoTranslateRight = (joystickR.getRawButton(Joystick1Ref.AUTO_TRANSLATE_RIGHT));
		shooterLifterUp = (joystickL.getRawButton(Joystick1Ref.SHOOTER_LIFTER_UP));
		shooterLifterDown = (joystickL.getRawButton(Joystick1Ref.SHOOTER_lIFTER_DOWN));
		
		
		//Joysticks
		joystickX = JoystickFilter.applyLinearDeadBand(joystickL.getX(),0.1);
		joystickY = -JoystickFilter.applyLinearDeadBand(joystickL.getY(),0.1);

		//Joysticks: finetuning on left and reg on right
//		if(joystickX == 0){
//			joystickX = DeadBand.applylinearDeadBand(joystickL.getX(), 0.1)/4;
//		}
//		if(joystickY == 0){
//			joystickY = -DeadBand.applylinearDeadBand(joystickL.getY(), 0.1)/4;
//		}
		
		//Theoretical Throttle
		joystickThrottle = joystickL.getThrottle();
		
		//TODO X and Y were switched on hardware, switched in software
		ReferenceData.getInstance().getUserInputData().setJoystickY(-joystickX);
		ReferenceData.getInstance().getUserInputData().setJoystickX(-joystickY);
		
		// activate solenoids on first action.
		if (liftUp || liftDown || shooterUp || shooterDown || shooterLifterUp || shooterLifterDown || shooterFire) {
			ReferenceData.getInstance().getSolenoidData().setShouldWeRunSolenoids(true);
		}
		
		ReferenceData.getInstance().getUserInputData().setLiftUp(liftUp);
		ReferenceData.getInstance().getUserInputData().setLiftDown(liftDown);
		ReferenceData.getInstance().getUserInputData().setShooterUp(shooterUp);
		ReferenceData.getInstance().getUserInputData().setShooterDown(shooterDown);
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(shooterSpeedUp);
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(shooterSpeedDown);
		ReferenceData.getInstance().getUserInputData().setShooterFire(shooterFire);
		ReferenceData.getInstance().getUserInputData().setBothUp(shooterLifterUp);
		ReferenceData.getInstance().getUserInputData().setBothDown(shooterLifterDown);
		ReferenceData.getInstance().getUserInputData().setThrottle(joystickThrottle);

		
	
		//Auto Tasks
//		ReferenceData.getInstance().getUserInputData().setAutoTranslateLeft(autoTranslateLeft);
//		ReferenceData.getInstance().getUserInputData().setAutoFireAll(autoFireAll);
//		ReferenceData.getInstance().getUserInputData().setAutoLift(autoLift);
//		ReferenceData.getInstance().getUserInputData().setAutoTranslateRight(autoTranslateRight);
		
		
		anyUIArr[0] = liftUp;
		anyUIArr[1] = liftDown;
		anyUIArr[2] = shooterUp;
		anyUIArr[3] = shooterDown;
		anyUIArr[4] = shooterSpeedUp;
		anyUIArr[5] = shooterSpeedDown;
		anyUIArr[6] = shooterFire;
		anyUIArr[7] = autoTranslateLeft;
		anyUIArr[8] = autoFireAll;
		anyUIArr[9] = autoLift;
		anyUIArr[10] = autoTranslateRight;
		anyUIArr[11] = joystickX > 0;
		anyUIArr[12] = joystickY > 0;
		anyUIArr[13] = shooterLifterUp;
		anyUIArr[14] = shooterLifterDown;
		ReferenceData.getInstance().getUserInputData().setAnyUI(false);
		for(int i = 0; i<anyUIArr.length; i++){
			if(anyUIArr[i])
				ReferenceData.getInstance().getUserInputData().setAnyUI(true);
		}
	}
}
