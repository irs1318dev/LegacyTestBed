package org.usfirst.frc1318.reference;

public class Quadratic implements Scale {

	public double scale(double x) {
		if(x < 0)
			return -x*x;
		return x*x;
	}
}