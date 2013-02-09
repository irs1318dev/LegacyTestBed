package org.usfirst.frc1318.FRC2013.components;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
/**
 * This class is a basic state machine that switches itself back and forth 
 * between extended and retracted when it should fire
 * 
 * to tell it when it should fire, use ShooterData.setShouldFire
 * 
 * @author Graham
 *
 */
public class ShooterFireRunner extends RobotComponentBase {
	
	private Solenoid extend, retract;
	Timer timer;
	int state = 0;
	double fireTime;
	final double fireDuration = .6;
	
	final int EXTENDED = 0;
	final int RETRACTED = 1;
	
	public void RobotInit()
	{
		timer = new Timer();
		extend = new Solenoid(PortRef.SHOOTER_FIRE_EXTEND);
		retract = new Solenoid(PortRef.SHOOTER_FIRE_RETRACT);
	}
	
	public void TeleopPeriodic()
	{
		
		/*
		 * basically this stuff says:
		 * if extended
		 * 		wait for fireDuration, then retract
		 * else
		 * 		check should fire
		 * 			check has frisbees
		 * 		extend
		 */
		if(state == EXTENDED)
		{
			if(timer.get() - fireTime >= fireDuration)
			{
				state = RETRACTED;
			}else{
				//extend
				extend.set(true);
				retract.set(false);
				return;
			}//if/else
		}else if(state == RETRACTED)
		{
			//if should fire
			if(ReferenceData.getInstance().getShooterData().getShouldFire())
			{
				//don't fire without frisbees
				if(!ReferenceData.getInstance().getShooterData().getHasFrisbees()){
					ReferenceData.getInstance().getShooterData().setShouldFire(false);
				}else{
					//fire
					state = EXTENDED;
					fireTime = timer.get();
					ReferenceData.getInstance().getShooterData().setShouldFire(false);
				}//has frisbees if/else
			}else{
				//retract
				extend.set(false);
				retract.set(true);
			}//should fire if/else
		}//state if/else
	}//teleopPeriodic
}
