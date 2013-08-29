package org.usfirst.frc1318.legoarmbot.calculators;

import org.usfirst.frc1318.legoarmbot.shared.Configuration;
import org.usfirst.frc1318.legoarmbot.shared.DeltaConfiguration;
import org.usfirst.frc1318.legoarmbot.shared.DeltaPoint;
import org.usfirst.frc1318.legoarmbot.shared.Point;

import com.sun.squawk.util.MathUtils;

public class TwoLinkArm {

	public Point configToPoint(Configuration config) {
		double x = config.getLength1() * Math.cos(config.getTheta1()) + config.getLength2() * Math.cos(config.getTheta2());
		double y = config.getLength1() * Math.sin(config.getTheta1()) + config.getLength2() * Math.sin(config.getTheta2());
		Point product = new Point(x, y);
		return product;
	}

	public Point numericalForwardKinematics(Configuration current, DeltaConfiguration change) {
		double jacobianA = -current.getLength1() * Math.sin(current.getTheta1()) - current.getLength2() * Math.sin(current.getTheta1() + current.getTheta2());
		double jacobianB = -current.getLength2() * Math.sin(current.getTheta1() + current.getTheta2());
		double jacobianC = current.getLength1() * Math.cos(current.getTheta1()) + current.getLength2() * Math.cos(current.getTheta1() + current.getTheta2());
		double jacobianD = current.getLength2() * Math.cos(current.getTheta1() + current.getTheta2());
		Point currentPoint = this.configToPoint(current);
		double xNew = currentPoint.getX() + jacobianA * change.getTheta1() + jacobianB * change.getTheta2();
		double yNew = currentPoint.getY() + jacobianC * change.getTheta1() + jacobianD * change.getTheta2();
		return new Point(xNew, yNew);
	}
	
	public Point closedFormForwardKinematics(Configuration desired) {
		double link1X = desired.getLength1() * Math.cos(desired.getTheta1());
		double link1Y = desired.getLength1() * Math.sin(desired.getTheta1());
		double link2X = desired.getLength2() * Math.cos(desired.getTheta1() + desired.getTheta2());
		double link2Y = desired.getLength2() * Math.sin(desired.getTheta1() + desired.getTheta2());
		return new Point(link1X + link2X, link1Y + link2Y);
	}

	public Configuration numericalInverseKinematics(Configuration current, DeltaPoint change) {
		double jacobianA = -current.getLength1() * Math.sin(current.getTheta1()) - current.getLength2() * Math.sin(current.getTheta1() + current.getTheta2());
		double jacobianB = -current.getLength2() * Math.sin(current.getTheta1() + current.getTheta2());
		double jacobianC = current.getLength1() * Math.cos(current.getTheta1()) + current.getLength2() * Math.cos(current.getTheta1() + current.getTheta2());
		double jacobianD = current.getLength2() * Math.cos(current.getTheta1() + current.getTheta2());
		double determinant = 1 / jacobianA * jacobianD - jacobianB * jacobianC;
		
		double iJacobianA = jacobianD / determinant;
		double iJacobianB = -jacobianB / determinant;
		double iJacobianC = -jacobianC / determinant;
		double iJacobianD = jacobianA / determinant;
		
		double theta1New = current.getTheta1() + iJacobianA * change.getX() + iJacobianB * change.getY();
		double theta2New = current.getTheta2() + iJacobianC * change.getX() + iJacobianD * change.getY();
		
		return new Configuration(theta1New, theta2New, current.getLength1(), current.getLength2());
		
		//TODO: Check for boundaries and singularities
	}
	
	public Configuration closedFormInverseKinematics(Configuration current, Point desired) {
		double c2 = ((desired.getX() * desired.getX()) + (desired.getY() * desired.getY()) 
				- (current.getLength1() * current.getLength1()) - (current.getLength2() * current.getLength2())) 
				/ (2 * current.getLength1() * current.getLength2());
			//closed form for negative cosine theta2
		double s2 = Math.sqrt(1 - (c2 * c2));
		double theta2 = MathUtils.atan2(s2,c2);
		double theta1FirstTerm = MathUtils.atan2(desired.getY(),desired.getX());
		double k1 = (current.getLength1() + current.getLength2() * c2);
		double k2 = (current.getLength2() * s2);
		double theta1SecondTerm = MathUtils.atan2( k2, k1);
		double theta1 = theta1FirstTerm - theta1SecondTerm;
		return new Configuration(theta1, theta2, current.getLength1(), current.getLength2());
	}

	
	
}
