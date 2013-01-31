package org.usfirst.frc1318;

import org.usfirst.frc1318.testbed.calculators.TBKickerCalculator;
import org.usfirst.frc1318.testbed.components.TBGamePadReader;
import org.usfirst.frc1318.testbed.components.TBHelloWorldRunner;
import org.usfirst.frc1318.testbed.components.TBSolenoidRunner;
import org.usfirst.frc1318.testbed.components.TBThroughBeamReader;

public class MainIterativeComponentRobot extends IterativeComponentRobot {

	public BotVector currentRobotComponents() {
		return MiniMikeNetworkTableTest();
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
}