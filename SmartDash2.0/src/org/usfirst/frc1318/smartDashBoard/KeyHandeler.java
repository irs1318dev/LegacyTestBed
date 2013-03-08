package org.usfirst.frc1318.smartDashBoard;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyHandeler {

	HashMap<String, String> keyMappings;
	ArrayList<String> keyOrder;
	
	static KeyHandeler instance;
	
	public static KeyHandeler getInstance() {
		if(instance == null) {
			instance = new KeyHandeler();
		}
		
		return instance;
	}
	
	private KeyHandeler() {
		keyMappings = new HashMap<String, String>();
		Integer value = new Integer(0);
		
//Add all values into table so they are more readable
//not required for display

		this.keyMappings.put("dt.re", "ENCODER R ");
		this.keyMappings.put("dt.le", "ENCNCODER L ");
		this.keyMappings.put("dt.rsp", "SETPOINT R ");
		this.keyMappings.put("dt.lsp", "SETPOINT L ");
		this.keyMappings.put("dt.rps", "VELOCITY R ");
		this.keyMappings.put("dt.lps", "VELOCITY L ");
		//this.keyMappings.put("l.sl", "LFT SL");
		this.keyMappings.put("lms.s", "LIMIT SWITCH");
		this.keyMappings.put("s.sp", "SHTR SPOINT");
		this.keyMappings.put("s.aes", "SHTR VEL");
		//this.keyMappings.put("s.m", "SHT M ");
		//this.keyMappings.put("s.hf", "SHT HF");
		//this.keyMappings.put("s.sf", "SHT SF");
		this.keyMappings.put("s.c", "SHTR CUR");
//		this.keyMappings.put("so.sbu", "SHT SU");
//		this.keyMappings.put("so.sbd", "LFT SU");
		this.keyMappings.put("so.su", "SHTR UP ");
		this.keyMappings.put("so.lu", "LIFT UP");
//		this.keyMappings.put("", "");
//		this.keyMappings.put("", "");
//		this.keyMappings.put("", "");
//		this.keyMappings.put("", "");
//		this.keyMappings.put("", "");
//		this.keyMappings.put("", "");
		

//This was an annoying class to code by the way
		
		keyOrder = new ArrayList<String>();
		
//this keeps the output in the right order
		this.keyOrder.add("s.sp");
		this.keyOrder.add("s.aes");
		this.keyOrder.add("dt.re");
		this.keyOrder.add("dt.le");
		this.keyOrder.add("dt.rsp");
		this.keyOrder.add("dt.lsp");
		this.keyOrder.add("dt.rps");
		this.keyOrder.add("dt.lps");
		//this.keyOrder.add("l.sl");
		this.keyOrder.add("lms.s");
		//this.keyOrder.add("s.m");
		//this.keyOrder.add("s.hf");
		//this.keyOrder.add("s.sf");
		this.keyOrder.add("s.c");
//		this.keyOrder.add("so.sbu");
//		this.keyOrder.add("so.sbd");
		this.keyOrder.add("so.su");
		this.keyOrder.add("so.lu");
		
	}
	
	public String makeReadable(String key){
		return keyMappings.get(key).toString();
	}
	
	public HashMap<String, String> getReadabilityMap() {
		return keyMappings;
	}
	
	public ArrayList<String> getKeyOrder() {
		return keyOrder;
	}
}
