package org.usfirst.frc1318.legoarmbot.shared;

import org.usfirst.frc1318.legoarmbot.shared.constants.RobotValues;

public class Configuration {

	double theta1;
	double theta2;
	double length1;
	double length2;
	
//	boolean isInTest;
//	
//	double theta2SingularityEpsilon;
	
//	@Deprecated
//	public Configuration(boolean isInTest) {
//		this.isInTest = isInTest;
//		if(isInTest) {
//			theta2SingularityEpsilon = RobotValues.TESTING_THETA2_SINGULARITY_EPSILON;
//		} else {
//			theta2SingularityEpsilon = RobotValues.THETA2_SINGULARITY_EPSILON;
//		}
//	}
	
	public Configuration(double theta1, double theta2, double length1, double length2) {
		this.theta1 = theta1;
		this.theta2 = theta2;
		this.length1 = length1;
		this.length2 = length2;

//		theta2SingularityEpsilon = RobotValues.THETA2_SINGULARITY_EPSILON;		
	}
	
	public Configuration() {
		
	}
	
//	public boolean isSingular() {
//		if(Math.abs(theta2) <= theta2SingularityEpsilon) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		} else if(o.getClass() != Configuration.class) {
			return false;
		} else {
			Configuration c = (Configuration) o;
			if(Math.abs(c.getTheta1() - this.getTheta1()) <= RobotValues.EQUALS_METHOD_EPSILON_CONFIGURATION && Math.abs(c.getTheta2() - this.getTheta2()) <= RobotValues.EQUALS_METHOD_EPSILON_CONFIGURATION &&
					Math.abs(c.getLength1() - this.getLength1()) <= RobotValues.EQUALS_METHOD_EPSILON_CONFIGURATION && Math.abs(c.getLength2() - this.getLength2()) <= RobotValues.EQUALS_METHOD_EPSILON_CONFIGURATION) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	
	
	
	public double getTheta1() {
		return theta1;
	}
	public void setTheta1(double theta1) {
		this.theta1 = theta1;
	}
	public double getTheta2() {
		return theta2;
	}
	public void setTheta2(double theta2) {
		this.theta2 = theta2;
	}
	public double getLength1() {
		return length1;
	}
	public void setLength1(double length1) {
		this.length1 = length1;
	}
	public double getLength2() {
		return length2;
	}
	public void setLength2(double length2) {
		this.length2 = length2;
	}
	
	
}