package org.usfirst.ihs1318.telemetry;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataValue {
	
	private String name;
	private DataType dataType;
	private List<RawData> values;
	private String publishedValue="No data";
	private boolean currentBoolean;
	private double currentDouble;
	private String currentString ="";

	private Map<String, DataType> dataTypes = new HashMap<String, DataType>();
	
	
	public DataValue() {
		String[] dtArray = FIELD_TYPES_2013.split("\n");
		for (String dt : dtArray) {
			String[] kv = dt.split("=");
			if ("Boolean".equalsIgnoreCase(kv[1].trim())) {
				dataTypes.put(kv[0].trim(), DataType.BOOLEAN);
			}
			else if ("Double".equalsIgnoreCase(kv[1].trim())) {
				dataTypes.put(kv[0].trim(), DataType.DOUBLE);
			}
			else {
				dataTypes.put(kv[0].trim(), DataType.STRING);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<RawData> getValues() {
		if (values==null) values = new ArrayList<RawData>();
		return values;
	}
	public void setValues(List<RawData> values) {
		this.values = values;
	}
	
	public void addRawData(RawData rd) {
		setDataType(dataTypes.get(rd.getName()));
		if (getDataType()==null) {
			System.out.println("No data type for "+rd.getName());
			return;
		}
		getValues().add(rd); 
		switch (getDataType()) {
		case BOOLEAN:
				if (!currentBoolean && "true".equalsIgnoreCase(rd.getRawData())) {
					currentBoolean = true;
				}
				break;
		case DOUBLE:
			// maintain running average
			// http://en.wikipedia.org/wiki/Standard_deviation#Rapid_calculation_methods
			double d = Double.parseDouble(rd.getRawData());
			currentDouble += (d - currentDouble)/getValues().size();
			break;
		case STRING:
			currentString = rd.getRawData();
			break;
		} 
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public String getPublishedValue() {
		switch(getDataType()) {
		case BOOLEAN:
			return ""+currentBoolean;
		case STRING:
			return currentString;
		case DOUBLE:
			return ""+currentDouble;
		}
		return publishedValue;
	}
	public void setPublishedValue(String publishedValue) {
		this.publishedValue = publishedValue;
	}
	
	public String toString() {
		return getDataType()+","+getName()+","+getValues().size()+","+getPublishedValue();
		
	}
	
	public static final String FIELD_TYPES_2013 = 
			"dt.re=Double\r\n"
					+ "dt.le=Double\r\n"
					+ "dt.rsp=Double\r\n"
					+ "dt.ldp=Double\r\n"
					+ "dt.rps=Double\r\n"
					+ "dt.lps=Double\r\n"
					+ "l.sl=Boolean\r\n"
					+ "lms.s=Boolean\r\n"
					+ "s.sp==Double\r\n"
					+ "s.aes=Double\r\n"
					+ "s.aest=Double\r\n"
					+ "s.m=Double\r\n"
					+ "s.hf=Boolean\r\n"
					+ "s.sf=Boolean\r\n"
					+ "s.c=String\r\n"
					+ "so.sbrun=Boolean\r\n"
					+ "so.sbu=Boolean\r\n"
					+ "so.lbu=Boolean\r\n"
					+ "so.fbe=Boolean\r\n"
					+ "so.su=Boolean\r\n"
					+ "so.lu=Boolean\r\n"
					+ "so.fe=Boolean\r\n"
					+ "i.ljs=Double\r\n"
					+ "i.rjs=Double\r\n"
					+ "i.jx=Double\r\n"
					+ "i.jy=Double\r\n"
					+ "i.ld=Boolean\r\n"
					+ "i.lu=Boolean\r\n"
					+ "i.sd=Boolean\r\n"
					+ "i.su=Boolean\r\n"
					+ "i.ssu=Boolean\r\n"
					+ "i.ssd=Boolean\r\n"
					+"i.sf=Boolean\r\n"
					+"spid.nto=Boolean\r\n"
					+"spid.vsp=Double\r\n"
					+"r.s=String\r\n";

	public static final String FIELD_TYPES_2011 = "Air=Boolean\r\n" + 
			"Tube=String\r\n" + 
			"armCV=Double\r\n" + 
			" armD=Double\r\n" + 
			" armEncR=Double\r\n" + 
			" armEncV=Double\r\n" + 
			" armH=String\r\n" + 
			" armV=Double\r\n" + 
			" bot=Boolean\r\n" + 
			" cFlip=String\r\n" + 
			" claw=Boolean\r\n" + 
			" gyro=Boolean\r\n" + 
			" jX=Double\r\n" + 
			" jY=Double\r\n" + 
			" jrY=Double\r\n" + 
			" lineC=Boolean\r\n" + 
			" lineD=String\r\n" + 
			" lineL=Boolean\r\n" + 
			" lineR=Boolean\r\n" + 
			" omega=Double\r\n" + 
			" theta=Double\r\n" + 
			" wLF=Double\r\n" + 
			" wLR=Double\r\n" + 
			" wRF=Double\r\n" + 
			" wRR=Double\r\n" + 
			" weLF=Double\r\n" + 
			" weLR=Double\r\n" + 
			" weRF=Double\r\n" + 
			" weRR=Double\r\n" + 
			" wrist=String\r\n" + 
			" wristD=Boolean\r\n" + 
			" wristP =Boolean";
}
