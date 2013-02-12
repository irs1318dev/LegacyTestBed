package org.usfirst.frc1318.generic.utils;

public class LookupEntry {

	private String rawInput;
	private double key;
	private double value;
	
	public LookupEntry(String rawInput) {
		this.rawInput = rawInput;
		init();
		
	}
	
	private void init() {
		int position = 0;
		while(rawInput.charAt(position)!=',') {
			position += 1;
		}
		String keyString = rawInput.substring(0, position);
		key = Double.valueOf(keyString).doubleValue();
	
		position = 0;
		while(rawInput.charAt(position)!=',') {
			position += 1;
		}
		position += 1 ;
		String valueString = rawInput.substring(position, rawInput.length());
		value = Double.valueOf(valueString).doubleValue();
		
	}
	
	public String getRawInput() {
		return rawInput;
	}

	public double getKey() {
		return key;
	}

	public double getValue() {
		return value;
	}
	
}
