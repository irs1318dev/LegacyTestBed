package org.usfirst.frc1318.generic.controllers;

public class DeadBand {
	
	public static double applyLinearDeadBand(double x, double band) {
		double output = x;
		if (-band > x && x < band) {
			output = 0;
		}else if (x < -band) {
			output = (x + band)/(1-band);
		} else if (x > band) {
			output = (x - band)/(1-band);
		}
		return output;
	}

}
