package org.usfirst.frc1318.legoarmbot.calculators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.usfirst.frc1318.legoarmbot.shared.*;
import org.usfirst.frc1318.legoarmbot.shared.constants.RobotValues;
import org.usfirst.frc1318.legoarmbot.calculators.TwoLinkArm;

public class TwoLinkArmTest {

	TwoLinkArm test;
	
	@Before
	public void inIt() {
		test = new TwoLinkArm();
	}
	
	@Test
	public void configToPointTest() {
		Configuration input = new Configuration(0, Math.PI/2, 3, 4);
		Point expected = new Point(3, 4);
		assertTrue(expected.equals(test.configToPoint(input)));
		assertTrue(false);
	}
	
	@Test
	public void jacobianForwardKinematicsTest() {
		Configuration input = new Configuration(0, Math.PI/2, 3, 3);
		DeltaConfiguration movement = new DeltaConfiguration(Math.PI/180, -Math.PI/180, 0, 0);
		Point expected = new Point(3, 3 + Math.PI/60);
		assertTrue(expected.equals(test.rateFK(input, movement)));
	}
	
	@Test
	public void jacobianInverseKinematicsTest() {
		Configuration input = new Configuration(0, Math.PI/2, 3, 3);
		DeltaPoint movement = new DeltaPoint(-.005, -.005);
		Configuration expected = new Configuration(-.005/3, Math.PI/2 + .01/3, 3, 3);
		assertTrue(expected.equals(test.rateIK(input, movement)));
	}
	
//	@Test
	public void checkIKAccuracyTest() {
		Configuration input = new Configuration(0, Math.PI/2, 3, 3);
		DeltaPoint movement1 = new DeltaPoint(-5, -5);
		DeltaPoint movement2 = new DeltaPoint(5, 5);
		Point start = test.configToPoint(input);
		Point end = test.configToPoint(test.rateIK(test.rateIK(input, movement1), movement2));
		System.out.println("System error is (" + (end.getX() - start.getY()) + ", " + (end.getY() - start.getY()) + ")");
	}
	
	@Test
	public void determineLargestStepAt1comma1() {
		double error = 0;
		double tolerance = .01;
		double step = 0;
		double stepIncrement = .0001;
		while(error < tolerance) {
			Configuration input = new Configuration(0, Math.PI/2, 3, 3);
//			DeltaPoint movement1 = new DeltaPoint(-step, -step);
//			DeltaPoint movement2 = new DeltaPoint(step, step);
			DeltaPoint movement1 = new DeltaPoint(step, step);
			DeltaPoint movement2 = new DeltaPoint(-step, -step);
			Point start = test.configToPoint(input);
			Point end = test.configToPoint(test.rateIK(test.rateIK(input, movement1), movement2));
			error = Math.sqrt(Math.pow(end.getX() - start.getY(), 2) + Math.pow(end.getY() - start.getY(), 2));
			step += stepIncrement;
		}
		System.out.println("Maximum step at (1, 1) is " + step * Math.sqrt(2) + ".");
	}
	
	@Test
	public void closedFormTestQuadrant1(){
		Point start = new Point(1, 1);
		Configuration current = new Configuration(0, 0, .9, .9);
		Configuration testValue = test.positionIK(current, start);
		assertTrue(start.equals(test.positionFK(testValue)));
	}
	
	@Test
	public void closedFormTestQuadrant2(){
		Point start = new Point(-1, 1);
		Configuration current = new Configuration(0, 0, .9, .9);
		Configuration testValue = test.positionIK(current, start);
		assertTrue(start.equals(test.positionFK(testValue)));
	}
	
	@Test
	public void closedFormTestQuadrant3(){
		Point start = new Point(-1, -1);
		Configuration current = new Configuration(0, 0, .9, .9);
		Configuration testValue = test.positionIK(current, start);
		assertTrue(start.equals(test.positionFK(testValue)));
	}
	
	@Test
	public void closedFormTestQuadrant4(){
		Point start = new Point(1, -1);
		Configuration current = new Configuration(0, 0, .9, .9);
		Configuration testValue = test.positionIK(current, start);
		assertTrue(start.equals(test.positionFK(testValue)));
	}
	
	@Test
	public void multipleSolutionsTest() {
		Point start = new Point(1, 1);
		Configuration current = new Configuration(0, 0, 1, 1);
		Configuration[] solutions = test.multipleSolutionPositionIK(current, start);
		Configuration up = new Configuration(Math.PI/2, -Math.PI/2, 1, 1);
		Configuration down = new Configuration(0, Math.PI/2, 1, 1);
		assertTrue(up.equals(solutions[RobotValues.UP]) && down.equals(solutions[RobotValues.DOWN]));
	}
}