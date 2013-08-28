package org.usfirst.frc1318.legoarmbot.shared;

import org.usfirst.frc1318.legoarmbot.shared.constants.RobotValues;

public class Point {
	
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		} else if(o.getClass() != Point.class) {
			return false;
		} else {
			Point p = (Point) o;
			if(Math.abs(p.getX() - this.getX()) <= RobotValues.EQUALS_METHOD_EPSILON_POINT && Math.abs(p.getY() - this.getY()) <= RobotValues.EQUALS_METHOD_EPSILON_POINT) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public Point() {
		
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
}