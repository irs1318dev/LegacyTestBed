package org.usfirst.frc1318.generic.controllers;

public class DeadBand {
	
	public static double applyLinearDeadBand(double x, double band) {
		double output = 0;
		if ((-band > x )&& (x < band)) {
			output = 0;
			System.out.println("Active deadband... "+x);
		} else if (x <= -band) {
			output = (x + band)/(1-band);
			System.out.println("Deadband negative... x="+x+", output"+output);
			
		} else if (x >= band) {
			output = (x - band)/(1-band);
			System.out.println("Deadband positive... x="+x+",output="+output);
		}
		return output;
	}

}
