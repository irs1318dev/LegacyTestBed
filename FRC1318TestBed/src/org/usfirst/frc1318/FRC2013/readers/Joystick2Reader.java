package org.usfirst.frc1318.FRC2013.readers;

import org.usfirst.frc1318.FRC2013.reference.GamePad1Ref;
import org.usfirst.frc1318.FRC2013.reference.Joystick1Ref;
import org.usfirst.frc1318.FRC2013.reference.Joystick2Ref;
import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.generic.controllers.JoystickFilter;
import org.usfirst.frc1318.generic.reference.GamePad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Joystick2Reader extends RobotComponentBase{
	
	private Joystick joystickL;
	private Joystick joystickR;
	
	private double joystickLeft;
	private double joystickRight;
	
	private boolean liftDown;
	private boolean liftUp;
	
	private boolean shooterDown;
	private boolean shooterUp;
	
	private boolean shooterSpeedUp;
	private boolean shooterSpeedDown;
	
	private boolean shooterSpeed0;
	private boolean shooterSpeedFull;
	
	private boolean shooterFire;
	
	private boolean autoTranslateRight;
	private boolean autoLift;
	private boolean autoFireAll;
	private boolean autoTranslateLeft;
	private boolean autoDriveShoot;
	private boolean autoSpinToAim;
	private boolean autoSpinToLoad;
	
	private boolean[] anyUIArr = new boolean[18];
	
	public void robotInit(){
		joystickL = new Joystick(PortRef.JOYSTICK_L);
		joystickR = new Joystick(PortRef.JOYSTICK_R);
	}

	long count;
	
	public void teleopPeriodic(){
		joystickLeft= - joystickL.getY(Hand.kLeft);
		joystickLeft= JoystickFilter.applyLinearDeadBand(joystickLeft,0.1);
		joystickRight = joystickR.getY(Hand.kRight);
		joystickRight = JoystickFilter.applyLinearDeadBand(joystickRight,0.1);
				
		liftUp = (joystickR.getRawButton(Joystick2Ref.LIFT_UP));
		liftDown = (joystickR.getRawButton(Joystick2Ref.LIFT_DOWN));
		shooterUp = (joystickR.getRawButton(Joystick2Ref.SHOOTER_UP));
		shooterDown = (joystickR.getRawButton(Joystick2Ref.SHOOTER_DOWN));
		shooterSpeedUp = (joystickR.getRawButton(Joystick2Ref.SHOOTER_SPEED_UP));
		shooterSpeedDown = (joystickR.getRawButton(Joystick2Ref.SHOOTER_SPEED_DOWN));
		shooterSpeed0 = (joystickR.getRawButton(Joystick2Ref.SHOOTER_SPEED_0));
		shooterSpeedFull = (joystickR.getRawButton(Joystick2Ref.SHOOTER_SPEED_FULL));
		shooterFire = (joystickR.getRawButton(Joystick2Ref.SHOOTER_FIRE));
		autoTranslateLeft = joystickL.getRawButton(Joystick2Ref.AUTO_TRANSLATE_LEFT);
		autoFireAll = joystickL.getRawButton(Joystick2Ref.AUTO_FIREALL);
		autoLift = joystickL.getRawButton(Joystick2Ref.AUTO_LIFT);
		autoTranslateRight = (joystickL.getRawButton(Joystick2Ref.AUTO_TRANSLATE_RIGHT));
		autoSpinToAim = (joystickL.getRawButton(Joystick2Ref.AUTO_SPIN_TO_AIM));
		autoSpinToLoad = (joystickL.getRawButton(Joystick2Ref.AUTO_SPIN_TO_LOAD));
		
		
		ReferenceData.getInstance().getUserInputData().setJoystickLeft(-joystickLeft);
		ReferenceData.getInstance().getUserInputData().setJoystickRight(-joystickRight);
		ReferenceData.getInstance().getUserInputData().setLiftUp(liftUp);
		ReferenceData.getInstance().getUserInputData().setLiftDown(liftDown);
		ReferenceData.getInstance().getUserInputData().setShooterUp(shooterUp);
		ReferenceData.getInstance().getUserInputData().setShooterDown(shooterDown);
		
		ReferenceData.getInstance().getUserInputData().setShooterSpeed0(shooterSpeed0);
		ReferenceData.getInstance().getUserInputData().setShooterSpeedFull(shooterSpeedFull);
		
		ReferenceData.getInstance().getUserInputData().setShooterSpeedUp(shooterSpeedUp);
		ReferenceData.getInstance().getUserInputData().setShooterSpeedDown(shooterSpeedDown);
		ReferenceData.getInstance().getUserInputData().setShooterFire(shooterFire);
		ReferenceData.getInstance().getUserInputData().setAutoTranslateLeft(autoTranslateLeft);
		ReferenceData.getInstance().getUserInputData().setAutoFireAll(autoFireAll);
		ReferenceData.getInstance().getUserInputData().setAutoLift(autoLift);
		ReferenceData.getInstance().getUserInputData().setAutoTranslateRight(autoTranslateRight);
		ReferenceData.getInstance().getUserInputData().setAutoSpinToAim(autoSpinToAim);
		ReferenceData.getInstance().getUserInputData().setAutoSpinToLoad(autoSpinToLoad);
		
		anyUIArr[0] = liftUp;
		anyUIArr[1] = liftDown;
		anyUIArr[2] = shooterUp;
		anyUIArr[3] = shooterDown;
		anyUIArr[4] = shooterSpeedUp;
		anyUIArr[5] = shooterSpeedDown;
		anyUIArr[6] = shooterSpeed0;
		anyUIArr[7] = shooterSpeedFull;
		anyUIArr[8] = shooterFire;
		anyUIArr[9] = autoTranslateLeft;
		anyUIArr[10] = autoFireAll;
		anyUIArr[11] = autoLift;
		anyUIArr[12] = autoTranslateRight;
		anyUIArr[13] = autoSpinToAim;
		anyUIArr[14] = autoSpinToLoad;
		anyUIArr[15] = joystickLeft > 0;
		anyUIArr[16] = joystickRight > 0;
		ReferenceData.getInstance().getUserInputData().setAnyUI(false);
		for(int i = 0; i<anyUIArr.length; i++){
			if(anyUIArr[i])
				ReferenceData.getInstance().getUserInputData().setAnyUI(true);
		}
		
		//if (count%100==0) {
		//System.out.println("intiialJYL= "+initialJYL+",jyL="
		//        +ReferenceData.getInstance().getUserInputData().getJoystickLeft()
		//		+", initialJYR="+initialJYR+" ,jyR= " 
		//		+ ReferenceData.getInstance().getUserInputData().getJoystickRight());
		//}
		//count++;

	}
}
