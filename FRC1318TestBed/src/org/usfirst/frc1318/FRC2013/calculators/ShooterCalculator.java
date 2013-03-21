package org.usfirst.frc1318.FRC2013.calculators;

import org.usfirst.frc1318.FRC2013.shared.ReferenceData;
import org.usfirst.frc1318.FRC2013.shared.ShooterData;
import org.usfirst.frc1318.components.RobotComponentBase;

import org.usfirst.frc1318.generic.networktable.IRSTable;
import org.usfirst.frc1318.generic.utils.SettingsLookup;


public class ShooterCalculator extends RobotComponentBase {
	
	public void robotInit()
	{
		IRSTable.putNumber(keyRoot + setponitKey, 
				new Double(ReferenceData.getInstance().getShooterData().getMotorSetPoint()));
	}
	
	boolean lastUpCommand = false;
	boolean lastDownCommand = false;

	final String keyRoot = "spid.";
	final String setponitKey = "vsp";
	final String ntOverrideKey = "nto";


	public void autonomousPeriodic() {
	  // do nothing here... autonomous sets the motor speed directly.
	}
	
	public void teleopPeriodic()
	{
		try {
			if(IRSTable.getBoolean(this.keyRoot + ntOverrideKey)) {
				double shooterSet = IRSTable.getNumber(this.keyRoot + setponitKey);
				ReferenceData.getInstance().getShooterData().setMotorSetPoint(
						shooterSet
						);
				System.out.println("ShooterCalc: overriding shooter setpoint to "+ shooterSet);
				return;
			}
		} catch (Exception ex) {
//			System.out.println("Exception reading shooter override, using lookup table.");
		}

		
		
//		System.out.println("***Shooter speed: " + ReferenceData.getInstance().getShooterData().getMotorSetPoint());
		boolean currentUpCommand = ReferenceData.getInstance().getUserInputData().getShooterSpeedUp();
		if (currentUpCommand && !lastUpCommand) { // do once every change
			lastUpCommand = currentUpCommand;
			ReferenceData.getInstance().getLookUpTable().upSpeed();
		} else if (!currentUpCommand && lastUpCommand){
			lastUpCommand = currentUpCommand;
		}
		boolean currentDownCommand = ReferenceData.getInstance().getUserInputData().getShooterSpeedDown();
		if (currentDownCommand && !lastDownCommand) { // do once every change
			lastDownCommand = currentDownCommand;
			ReferenceData.getInstance().getLookUpTable().downSpeed();
		} else if (!currentDownCommand && lastDownCommand){
			lastDownCommand = currentDownCommand;
		}
		
		ReferenceData.getInstance().getShooterData().setMotorSetPoint(
				ReferenceData.getInstance().getLookUpTable().getValue()
				);
		
	}
		
}
