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
 * 
 * 
 * TODO
 * 		More efficient integral algorithm
 * 
 * @author Graham
 */
public class PID implements FeedbackController
{
	//constants
	double ki = 1;	//for integral
	double kd = 1;	//for d/dx
	double kp = 1;	//for p
	double kf = 1;	//for something else
	double kFade = .2;
	
	//feedback data
	double input = 0;
	double lastInput = 0;
	double setpoint = 0;
	double integral;		//integral of error data in memory
	double slope = 0;			//approximate slope of input.. units in / seconds
	double dt = 0;
	double prevTime;
	double error = 0;
	double curTime = 0;
	
	//outputData
	double maxOutput =  10000000;
	double minOutput = -10000000;
	
	//other vars
	Timer timer;
	double timeStep = .001;

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
		
		timer = new Timer();
		timer.start();
		prevTime = timer.get();
		
		//TODO initialization stuff for integral?
	}
	
	//second for no feed-forward
	
	public PID(double ki, double kd, double kp)
	{
		this.ki = ki;
		this.kd = kd;
		this.kp = kp;
		
		timer = new Timer();
		timer.start();
		prevTime = timer.get();
		
		//TODO initialization stuff for integral?
	}

////////////////////////////////////////////////////////////////////////////////
	
	public void input(double input)
	{
		lastInput = this.input;
		this.input = input;
		
		this.update();
	}
	
	
////////////////////////////////////////////////////////////////////////////////
	
	public void inputForward(double value)
	{
		//TODO implement feed-forward control
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	public double getOutput()
	{
		double output = kp * error + ki * integral + kd * input + kf * setpoint;
		output = clamp(output);
		
		return output;
	}
	
	
//Private methods
////////////////////////////////////////////////////////////////////////////////
	
	//this updates essential values
	private void update()
	{
		//update dt
		curTime = timer.get(); 	
		dt = curTime - this.prevTime;
		
		//To prevent division by zero, output updates at a max of 1kHz
		if(dt > timeStep)
		{
			this.prevTime = curTime;
			
			
			//update calculated values
			updateError();
			updateIntegral();
			updateSlope();
			
		}
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	//this ensures that value is within bounds, and if it isn't return bound
	private double clamp(double value, double low, double high)
	{
		if(value > high)
			return high;
		else if(value < low)
			return low;
		else return value;
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	private double clamp(double value)
	{
		if(value > maxOutput)
			return maxOutput;
		else if(value < minOutput)
			return minOutput;
		else return value;
		
	}

////////////////////////////////////////////////////////////////////////////////

	private void updateError()
	{
		error = input - setpoint;
	}
	
////////////////////////////////////////////////////////////////////////////////
	//This method updates the integral value
	private void updateIntegral()
	{
		double temp = integral;
		
		//TODO This is a pseudo algorithm and should be changed to something 
		//that might actually work
		temp *= kFade * (error);
		
		integral = clamp(temp, -2000, 2000);
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	//this method uses input and dt to find the rate of change of 
	private void updateSlope()
	{
		slope = (input - lastInput) / (dt);
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