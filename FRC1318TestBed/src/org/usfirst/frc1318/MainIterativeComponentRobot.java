package org.usfirst.frc1318;

import org.usfirst.frc1318.autonomous.AutoRunner;
import org.usfirst.frc1318.minimike.calculators.MMCalculator;
import org.usfirst.frc1318.minimike.components.MMGamePadReader;
import org.usfirst.frc1318.minimike.components.MMLimitSwitchReader;
import org.usfirst.frc1318.minimike.components.MMNetworkTableRunner;
import org.usfirst.frc1318.minimike.components.MMTurretRunner;
import org.usfirst.frc1318.testbed.calculators.TBKickerCalculator;
import org.usfirst.frc1318.testbed.components.TBGamePadReader;
import org.usfirst.frc1318.testbed.components.TBHelloWorldRunner;
import org.usfirst.frc1318.testbed.components.TBSolenoidRunner;
import org.usfirst.frc1318.testbed.components.TBThroughBeamReader;
import org.usfirst.frc1318.FRC2013.calculators.*;
import org.usfirst.frc1318.FRC2013.controllers.*;
import org.usfirst.frc1318.FRC2013.readers.*;
import org.usfirst.frc1318.FRC2013.runners.*;

public class MainIterativeComponentRobot extends IterativeComponentRobot {

	public BotVector currentRobotComponents() {
//		return shooterPIDBot();
		return gameBot1();
		//return helloBot();
	}
	
	protected static BotVector PIDTest()
	{
		BotVector b = new BotVector();
		b.add(new Joystick2Reader());
		b.add(new DriveTrainEncoderReader());
		b.add(new DriveTrain2JoysticksCalculator());
		b.add(new DriveTrainPIDCalculator());
		b.add(new DriveTrainRunner());
		b.add(new NetworkTableRunner());
		return b;
	}
	protected static BotVector gameBot1()
	{
		BotVector botVector = new BotVector();
		botVector.add(new CompressorRunner());
		botVector.add(new Joystick1Reader());
		botVector.add(new DriveTrainEncoderReader());
		botVector.add(new ShooterEncoderReader());
		System.out.println("*************************before AutoRunner");
		//botVector.add(new AutoRunner());
		System.out.println("*************************after AutoRunner");
		botVector.add(new ShooterCalculator());
		botVector.add(new SolenoidCalculator());
		botVector.add(new DriveTrain1JoystickCalculator());
		botVector.add(new DriveTrainPIDCalculator());
		botVector.add(new DriveTrainRunner());
		botVector.add(new ShooterPIDCalculator());
		botVector.add(new ShooterMotorRunner());
		botVector.add(new SolenoidRunner());
		botVector.add(new NetworkTableRunner());
		return botVector;
	}
	
	protected static BotVector gameBot2()
	{
		BotVector botVector = new BotVector();
		botVector.add(new CompressorRunner());
		botVector.add(new Joystick2Reader());
		botVector.add(new DriveTrainEncoderReader());
		botVector.add(new ShooterEncoderReader());
		botVector.add(new AutoRunner());
		botVector.add(new ShooterCalculator());
		botVector.add(new SolenoidCalculator());
		botVector.add(new DriveTrain2JoysticksCalculator());
		botVector.add(new DriveTrainPIDCalculator());
		botVector.add(new DriveTrainRunner());
		botVector.add(new ShooterPIDCalculator());
		botVector.add(new ShooterMotorRunner());
		botVector.add(new SolenoidRunner());
		botVector.add(new NetworkTableRunner());
		return botVector;
	}

	protected static BotVector demoBot1()
	{
		BotVector botVector = new BotVector();
		botVector.add(new GamePad1Reader());
		botVector.add(new ShooterCalculator());
		botVector.add(new SolenoidCalculator());
		botVector.add(new DriveTrain1JoystickCalculator());
		botVector.add(new DriveTrainNoPIDCalculator());
		botVector.add(new DriveTrainRunner());
		botVector.add(new ShooterMotorRunner());
		botVector.add(new CompressorRunner());
		//botVector.add(new SolenoidRunner());
		botVector.add(new NetworkTableRunner());
		return botVector;
	}
	
	protected static BotVector driveTrainTestBot()
	{
		BotVector botVector = new BotVector();
		botVector.add(new GamePad1Reader());
		botVector.add(new DriveTrainEncoderReader());
		botVector.add(new DriveTrain1JoystickCalculator());
		botVector.add(new DriveTrainNoPIDCalculator());
		botVector.add(new DriveTrainRunner());
		return botVector;
	}
	
	protected static BotVector gamepadTest(){
		BotVector botVector = new BotVector();
		botVector.add(new Joystick1Reader());
		botVector.add(new AutoRunner());
		return botVector;
	}
	
	protected static BotVector gamePadBot()
	{
		BotVector botVector = new BotVector();
		botVector.add(new GamePad1Reader());
		botVector.add(new NetworkTableRunner());
		return botVector;
	} 
	
	protected static BotVector shooterPIDBot() {
		BotVector b = new BotVector();
		b.add(new Joystick1Reader());
		b.add(new ShooterEncoderReader());
		b.add(new ShooterPIDCalculator());
		b.add(new ShooterCalculator());
		b.add(new ShooterMotorRunner());
		return b;
	}
	
	protected static BotVector compressorTestBot(){
		BotVector botVector = new BotVector();
		botVector.add(new CompressorRunner());
		return botVector;
	}
	
	protected static BotVector competitionBot(){
		BotVector botVector = new BotVector();
		
		botVector.add(new DriveTrainEncoderReader());
		botVector.add(new GamePad1Reader());
		botVector.add(new Joystick1Reader());
		botVector.add(new LifterLimitSwitchReader());
		//botVector.add(new ShooterEncoderReader());
		
		//Autonomous Here
		
		botVector.add(new LifterCalculator());
		botVector.add(new DriveTrain2JoysticksCalculator());
		botVector.add(new SolenoidCalculator());
		botVector.add(new ShooterCalculator());
		
		botVector.add(new DriveTrainPIDCalculator());
		//TODO add back in once working 
		//botVector.add(new ShooterPIDRunner());
		//botVector.add(new ShooterPIDRunner());
		
		botVector.add(new CompressorRunner());
		botVector.add(new DriveTrainRunner());
		botVector.add(new LifterRunner());
		botVector.add(new ShooterFireRunner());
		botVector.add(new ShooterMotorRunner());
		botVector.add(new NetworkTableRunner());
		return botVector;
		
	}
	
	protected static BotVector motorTest() {
		BotVector botVector = new BotVector();
		botVector.add(new GamePad1Reader());
		botVector.add(new ShooterCalculator());
		botVector.add(new ShooterMotorRunner());
		botVector.add(new NetworkTableRunner());
		return botVector;
	}
	protected static BotVector solenoidRunnerTest(){
		BotVector botVector = new BotVector();
		botVector.add(new GamePad1Reader());
		botVector.add(new SolenoidCalculator());
		botVector.add(new CompressorRunner());
		//botVector.add(new SolenoidRunner());
		
		return botVector;
	}
	
	protected static BotVector solenoidTest(){
		BotVector botVector = new BotVector();
		
		botVector.add(new CompressorRunner());
		//botVector.add(new SolenoidFireTestRunner());
		//botVector.add(new SolenoidArmTestRunner());
		botVector.add(new SolenoidShooterTrayTestRunner());
		
		return botVector;
	}

	protected static BotVector helloBot() {
		BotVector botVector = new BotVector();
		return botVector;
	}
	
	protected static BotVector pneumaticTestBed() {
		BotVector botVector = new BotVector();
		botVector.add(new TBGamePadReader());
		botVector.add(new TBKickerCalculator());
		botVector.add(new TBSolenoidRunner());
		botVector.add(new TBThroughBeamReader());
		
		return botVector;
	}
	
	protected static BotVector helloWorld(){
		BotVector botVector = new BotVector();
		botVector.add(new TBHelloWorldRunner());
		return botVector;
	}
	
	protected static BotVector MiniMikeVector()
	{
		BotVector bv = new BotVector();
		bv.add(new TBGamePadReader());
		
		//TODO add more components
		
		return bv;
	}
	
	protected static BotVector MiniMikeNetworkTableTest() {
		BotVector botVector = new BotVector();
		botVector.add(new org.usfirst.frc1318.minimike.networktable.NetworkTableTest());
		return botVector;
	}
	
	protected static BotVector MiniMikeVector2(){
		BotVector botVector = new BotVector();
		botVector.add(new MMGamePadReader());
		botVector.add(new MMLimitSwitchReader());
		botVector.add(new AutoRunner());
		botVector.add(new MMCalculator());
        botVector.add(new MMTurretRunner());
		botVector.add(new MMNetworkTableRunner());
		return botVector;
	}
}
