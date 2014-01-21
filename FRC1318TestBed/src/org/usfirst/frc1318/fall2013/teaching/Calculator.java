package org.usfirst.frc1318.fall2013.teaching;

public class Calculator {
	
	public int add(int x, int y){
		return x + y;
	}
	
	public int subtract(int x, int y){
		return x - y;
	}
	
	public int multiply(int x, int y){
		return x * y;
	}
	
	public int divide(int x, int y){
		return x / y;
	}
	
	public void numberSize(int x, int y){
		if(x > y){
			System.out.println(x);
		}else if(y > x){
			System.out.println(y);
		}else{
			System.out.println("They are equal");
		}
	}
	
}
