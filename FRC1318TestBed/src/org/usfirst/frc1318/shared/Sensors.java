package org.usfirst.frc1318.shared;

import org.usfirst.frc1318.reference.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

public class Sensors {
	private static Sensors sensors;
	public static Sensors getInstance() {
		if(sensors == null)
			sensors = new Sensors();
		return sensors; 
	}
	
	public static void clear() {
		sensors = null;
	}

	private GamePad pilotPad;
	private GamePad copilotPad;
	private Joystick[] joysticks;
	private DigitalInput autonomousSwitch;
	
	private Sensors() {}//restrict access for singleton object
	
	public GamePad getPilotGamePad() {
		if(pilotPad == null)
			throw new SensorNotInitializedException("Pilot game pad was not initialized");
		return pilotPad;
	}
	
	public void setPilotGamePad(GamePad pilotPad) {
		this.pilotPad = pilotPad;
	}
	
	public GamePad getCopilotGamePad() {
		if(copilotPad == null)
			throw new SensorNotInitializedException("Copilot pad was not intialized");
		return copilotPad;
	}
	
	public void setCopilotGamePad(GamePad copilotPad) {
		this.copilotPad = copilotPad;
	}

	/**
	 * Returns an array containing references to each of the joysticks.
	 * 
	 * Must call the setJoysticks method once before calling this.
	 * 
	 * @return {0=>pilotLeft, 1=>pilotRight, 2=>copilot}
	 */
	public Joystick[] getJoysticks() {
		if(joysticks == null)
			throw new SensorNotInitializedException("Joysticks were not initialized");
		return joysticks;
	}
	
	/**
	 * 
	 * @param pilotLeft
	 * @param pilotRight
	 * @param copilot
	 */
	public void setJoysticks(Joystick pilotLeft, Joystick pilotRight, Joystick copilot) {
		if(pilotLeft == null || pilotRight == null || copilot == null)
			throw new SensorNotInitializedException("One of the joysticks passed in was null");
		joysticks = new Joystick[] {pilotLeft, pilotRight, copilot};
	}

//	/**
//	 * 
//	 * @return The switch that sets the mode to run autonomous in.
//	 */
//	public DigitalInput getAutonomousSwitch() {
//		if(autonomousSwitch == null)
//			throw new SensorNotInitializedException("Autonomous sensor not initialized");
//		return autonomousSwitch;
//	}
//	/**
//	 * 
//	 * Sets the switch that autonmous uses to choose its mode.
//	 */
//	public void setAutonomousSwitch(DigitalInput autonomousSwitch) {
//		this.autonomousSwitch = autonomousSwitch;
//	}
}
