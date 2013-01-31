package org.usfirst.frc1318.generic.controllers;

import edu.wpi.first.wpilibj.Timer;


/**
 * 
 * in the event of strange behavior check todo tag locations
 * 
 * ***THIS CLASS IS NOT FINISHED****
 * 
 * To use pid control:
 * 		set the setpoint
 * 		feed input values regularly
 * 		use output values 
 * 
 * for reference:
 *	 	http://en.wikipedia.org/wiki/PID_controller
 * 		http://en.wikipedia.org/wiki/Feed_forward_(control)
 * 
 * @author Graham
 */
public class PID implements FeedbackController
{
	//proportionality constants
	double ki = 1;	//for integral
	double kd = 1;	//for d/dx
	double kp = 1;	//for p
	double kf = 1;	//for something else
	
	//feedback data
	double input = 0;
	double lastInput = 0;
	int inputIndex = 0;
	double setpoint = 0;
	double[] memory;		//store error data in here; access with WriteMemory
	int memIndex = 0;
	int memSize;
	double integral;		//integral of error data in memory
	double slope = 0;			//approximate slope of input.. units in / seconds
	double dt = 0;
	double prevTime;
	double curTime = 0;
	
	//outputData
	double maxOutput =  1;
	double minOutput = -1;
	
	//other vars
	Timer timer;

	
	/**
	 * This constructor initializes the object and sets constants to affect gain
	 */
	public PID(int memorySize, double ki, double kd, double kp, double kf)
	{
		this.memSize = memorySize;
		this.ki = ki;
		this.kd = kd;
		this.kp = kp;
		this.kf = kf;
		
		//timer = new Timer();  TODO uncomment for deploy
		
		//initialize memory
		memory = new double[memSize];
		for(int i = 0; i < memSize; i++)
		{
			memory[i] = 0;
		}
	}
	
	public void input(double input)
	{
		lastInput = this.input;
		this.input = input;
		
		this.update();
	}
	
	public double output()
	{
		//TODO calculate output
		return 0;
	}
	
//Private methods
	
	/*
	 * This array keeps track of previous velocities in an array that is written
	 * to in a circular manner to ensure that it fades
	 * 
	 * @param value will be written to the array
	 */
	private void WriteMemmory(double value)
	{
		memory[memIndex] = value;
		memIndex = ++memIndex % memSize;
	}
	
	
	//this updates essential values
	private void update()
	{
		//update dt
		//curTime = timer.get(); 			TODO Uncomment this for deployment
		dt = curTime - this.prevTime;
		
		//To prevent division by zero, output updates at a max of 1kHz
		if(dt > .001)
		{
			this.prevTime = curTime;
			
			//Update memory with current error
			this.WriteMemmory((input - setpoint) * dt);
			
			
			//update calculated values
			updateIntegral();
			updateSlope();
			
		}
	}
	
	//this ensures that value is within bounds, and if it isn't returns bound
	private double clamp(double value, double low, double high)
	{
		if(value > high)
			return high;
		else if(value < low)
			return low;
		else return value;
	}
	
	//This method updates the integral value
	private void updateIntegral()
	{
		//update Integral value
		double tempIntegral = 0;
		for(int i = 0; i < memSize; i++)
		{
			tempIntegral += memory[i];
		}
		
		//TODO: these values were copied from old pid class
		integral = clamp(tempIntegral, -2000, 2000);
	}
	
	//this method uses input and dt to find the rate of change of 
	private void updateSlope()
	{
		slope = (input - lastInput) / (dt);
	}
	
//getters and setters
	
	public void setTimer(Timer timer)
	{
		this.timer = timer;
	}
	
	public void setSetpoint(double setpoint)
	{
		this.setpoint = setpoint;
	}
	
	public double getIntegral()
	{
		return integral;
	}
	
	public double getSlope()
	{
		return slope;
	}
	
	public void setTime(double time)
	{
		curTime = time;
	}
}