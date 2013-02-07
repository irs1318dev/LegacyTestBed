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
public class PID
{
	//instance constants
	double ki = 0;	//for integral
	double kd = 0;	//for d/dx
	double kp = 0;	//for p
	double kf = 0;	//for something else
	double kFade = 0;
	int clampMode = -1;
	
	//feedback data
	double input = 0;
	double lastError = 0;
	double setpoint = 0;
	double integral;		//integral of error data in memory
	double slope = 0;			//approximate slope of input.. units in / seconds
	double dt = .001;
	double prevTime;
	double error = 0;
	double curTime = 0;
	double output = 0;
	
	//outputData
	double maxOutput =  10000000;
	double minOutput = -10000000;
	double clampRatio = 1;
	double clampMagnitude = 10000000;
	
	//other vars
	Timer timer;
	double timeStep = .001;
	
	//static constants
	public static final int CLAMP_NONE = -1;
	public static final int CLAMP_RATIO = 0;
	public static final int CLAMP_RANGE = 1;
	public static final int CLAMP_MAGNITUDE = 2;
	

////////////////////////////////////////////////////////////////////////////////
	/**
	 * This constructor initializes the object and sets constants to affect gain
	 * 
	 * Get rid of memmorySize
	 */
	public PID(double ki, double kd, double kp, double kf)
	{
		this.ki = ki;
		this.kd = kd;
		this.kp = kp;
		this.kf = kf;
		this.clampMode = clampMode;
		
		/*
		timer = new Timer();
		timer.start();
		prevTime = timer.get();
//		*/
		
		//TODO uncomment^^^^
	}
	
	//second for no feed-forward
	
	public PID(double ki, double kd, double kp)
	{
		this.ki = ki;
		this.kd = kd;
		this.kp = kp;
		/*
		timer = new Timer();
		timer.start();
		prevTime = timer.get();
//		*/
		
		//TODO uncomment^^^^
	}

////////////////////////////////////////////////////////////////////////////////
	
	public void input(double input)
	{
		this.input = input;
		
		//update dt
		curTime = timer.get(); 	
		dt = curTime - this.prevTime;
		
		//To prevent division by zero, output updates at a max of 1kHz
		if(dt >= timeStep)
		{
			this.update();
			this.calculateOutput();
		}
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	private void calculateOutput()
	{
		output = kp * error + ki * integral + kd * slope + kf * setpoint;
		output = clamp(output);
	}
	
////////////////////////////////////////////////////////////////////////////////
	public double getOutput()
	{
		return output;
	}
	
//Private methods
////////////////////////////////////////////////////////////////////////////////
	
	//this updates essential values
	private void update()
	{
		this.prevTime = curTime;
		
		//update calculated values
		updateError();
		updateIntegral();
		updateSlope();
		
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	private double clamp(double value)
	{
		switch(clampMode){
		
		case CLAMP_RANGE:
			
			if(value > maxOutput)
				return maxOutput;
			else if(value < minOutput)
				return minOutput;
			else return value;
			
		case CLAMP_RATIO:
			
			double ratmax = setpoint + setpoint*Math.abs(clampRatio);
			double ratmin = setpoint - setpoint*Math.abs(clampRatio);
			
			if(value > ratmax)
				return ratmax;
			else if(value < ratmin)
				return ratmin;
			else return value;
			
		case CLAMP_MAGNITUDE:
			
			double magmax = setpoint + Math.abs(clampMagnitude);
			double magmin = setpoint - Math.abs(clampMagnitude);
			
			if(value > magmax)
				return magmax;
			else if(value < magmin)
				return magmin;
			else 
				return value;
			
		default:
			return value;
		}
	}

////////////////////////////////////////////////////////////////////////////////

	private void updateError()
	{
		lastError = error;
		error = input - setpoint;
	}
	
////////////////////////////////////////////////////////////////////////////////
	//This method updates the integral value
	private void updateIntegral()
	{
		integral *= kFade * dt;
		integral += error * dt;
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	//this method uses input and dt to find the rate of change of 
	private void updateSlope()
	{
		slope = (error - lastError) / (dt);
	}
	
////////////////////////////////////////////////////////////////////////////////
//getters and setters///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////	

////////////////////////////////////////////////////////////////////////////////
	//for not feed forward
	public void setConstants(double kp, double ki, double kd)
	{
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
	}
	
////////////////////////////////////////////////////////////////////////////////
	//for feed forward
	public void setConstants(double kp, double ki, double kd, double kf)
	{
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
		this.kf = kf;
	}

////////////////////////////////////////////////////////////////////////////////
	public void setKp(double kp){this.kp = kp;}
	public void setKi(double ki){this.ki = ki;}
	public void setKd(double kd){this.kd = kd;}
	public void setKf(double kf){this.kf = kf;}
	public void setKFade(double kFade){this.kFade = kFade;}
	public void setMaxOutput(double value){this.maxOutput = value;}
	public void setMinOutput(double value){this.minOutput = value;}
	
////////////////////////////////////////////////////////////////////////////////

	
	public void setClampRange(double min, double max)
	{ 
		this.clampMode = CLAMP_RANGE;
		this.minOutput = min; 
		this.maxOutput = max;
	}
	
	public void setClampRatio(double ratio)
	{
		this.clampMode = CLAMP_RATIO;
		this.clampRatio = ratio;
	}
	
	public void setClampMagnitude(double magnitude)
	{
		this.clampMode = CLAMP_MAGNITUDE;
		this.clampMagnitude = magnitude;
	}
	
	public void setClampMode(int clampMode)
	{
		this.clampMode = clampMode;
	}
	
////////////////////////////////////////////////////////////////////////////////
	public void setTimer(Timer timer)
	{
		this.timer = timer;
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public void setSetpoint(double setpoint)
	{
		this.setpoint = setpoint;
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public double getIntegral()
	{
		return integral;
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public double getSlope()
	{
		return slope;
	}
	
}