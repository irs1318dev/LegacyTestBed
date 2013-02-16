package org.usfirst.frc1318.FRC2013.runners;

import org.usfirst.frc1318.FRC2013.reference.PortRef;
import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.SolenoidTestData;
import org.usfirst.frc1318.components.RobotComponentBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;

public class SolenoidFireTestRunner extends RobotComponentBase{
	DoubleSolenoid fireSolenoid;
	SolenoidTestData data;
	Timer timer;
	long prevTime;
	long onDuration = 3000; // ms
	long offDuration= 1000;//ms
	double onTime = 150000; // us
	double offTime =  200000; // us
	
	public void robotInit()
	{
		fireSolenoid = new DoubleSolenoid(PortRef.SHOOTER_FIRE_EXTEND, PortRef.SHOOTER_FIRE_RETRACT);
		data = ReferenceData.getInstance().getSolenoidTestData();
		data.state = 0;
		timer = new Timer();
		timer.start();
	}

	boolean started;
	public void teleopPeriodic()
	{
		
		/*
		 * state machine.  
		 * even numbers set initial condition
		 * odd numbers check if finished, turn off solenoid, reset data and 
		 * 		incremnt sate counter 
		 */
		if (!started) {
			prevTime = System.currentTimeMillis();
			started = true;
			System.out.println("started solenoid value=" + fireSolenoid.get().value);
		}

		switch(data.state)
		{
		case 0:
			data.startTime = timer.get();
			fireSolenoid.set(Value.kForward);
			if (System.currentTimeMillis() - prevTime > onDuration)
			{
				data.state = 1;
				prevTime = System.currentTimeMillis();
				System.out.println("state changed to: " + data.state+", solenoid value= Forward");
			}
			break;
		case 1:

			fireSolenoid.set(Value.kReverse);
			if (System.currentTimeMillis() - prevTime > onDuration)
			{
				data.state = 0;
				prevTime = System.currentTimeMillis();
				System.out.println("state changed to: " + data.state+", solenoid value= Reverse");
			}
			break;
			
			
		}//state
	}//method
}
