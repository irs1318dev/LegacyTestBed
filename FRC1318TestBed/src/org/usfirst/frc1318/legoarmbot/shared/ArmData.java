package org.usfirst.frc1318.legoarmbot.shared;

public class ArmData {
	
	private double theta1Encoder, theta2Encoder;
	private double theta1EncoderTicks, theta2EncoderTicks;
	private double theta1PositionSetPoint, theta2PositionSetPoint;	//read from joystick
	private Configuration currentConfiguration;
															//-1 to +1 
	private double theta1PIDSpeed, theta2PIDSpeed;
	public double getTheta1Encoder() {
		return theta1Encoder;
	}
	public void setTheta1Encoder(double theta1Encoder) {
		this.theta1Encoder = theta1Encoder;
	}
	public double getTheta2Encoder() {
		return theta2Encoder;
	}
	public void setTheta2Encoder(double theta2Encoder) {
		this.theta2Encoder = theta2Encoder;
	}
	public double getTheta1EncoderTicks() {
		return theta1EncoderTicks;
	}
	public void setTheta1EncoderTicks(double theta1EncoderTicks) {
		this.theta1EncoderTicks = theta1EncoderTicks;
	}
	public double getTheta2EncoderTicks() {
		return theta2EncoderTicks;
	}
	public void setTheta2EncoderTicks(double theta2EncoderTicks) {
		this.theta2EncoderTicks = theta2EncoderTicks;
	}
	public double getTheta1PositionSetPoint() {
		return theta1PositionSetPoint;
	}
	public void setTheta1PositionSetPoint(double theta1PositionSetPoint) {
		this.theta1PositionSetPoint = theta1PositionSetPoint;
	}
	public double getTheta2PositionSetPoint() {
		return theta2PositionSetPoint;
	}
	public void setTheta2PositionSetPoint(double theta2PositionSetPoint) {
		this.theta2PositionSetPoint = theta2PositionSetPoint;
	}
	public double getTheta1PIDSpeed() {
		return theta1PIDSpeed;
	}
	public void setTheta1PIDSpeed(double theta1pidSpeed) {
		theta1PIDSpeed = theta1pidSpeed;
	}
	public double getTheta2PIDSpeed() {
		return theta2PIDSpeed;
	}
	public void setTheta2PIDSpeed(double theta2pidSpeed) {
		theta2PIDSpeed = theta2pidSpeed;
	}
	public Configuration getCurrentConfiguration() {
		return currentConfiguration;
	}
	public void setCurrentConfiguration(Configuration currentConfiguration) {
		this.currentConfiguration = currentConfiguration;
	}
	
}