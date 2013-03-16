package org.usfirst.frc1318.smartDashBoard.UI;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.usfirst.frc1318.smartDashBoard.ConnectionListener;
import org.usfirst.frc1318.smartDashBoard.KeyHandeler;
import org.usfirst.frc1318.smartDashBoard.TableManager;
import org.usfirst.frc1318.smartDashBoard.constants.ReferenceData;

@SuppressWarnings("serial")
public class StatusPanel extends JTextArea implements ConnectionListener {
	StringBuilder builder;
	TableManager tableManager;
	KeyHandeler keyHandeler;

	
	
	public StatusPanel(JFrame frame){
		super();
		this.setEditable(false);
		
		this.setAutoscrolls(false);
		
		this.setPreferredSize(new Dimension(frame.getWidth() * 2 / 7, 
				frame.getHeight()));
		
		keyHandeler = KeyHandeler.getInstance();
		builder = new StringBuilder();
		tableManager = TableManager.getInstance();
		tableManager.addListener(this);
		
	}
	
	private void printHashMap(){
		
		this.builder.setLength(0);
		this.builder.append("VALUES FROM BOT \n \n");
		
		ArrayList<String> keys = keyHandeler.getKeyOrder();

		for(String key : keys) {

			String message = KeyHandeler.getInstance().getReadabilityMap().get(key);
			Object stored;
			String value;
			
			if(message == null) {
				continue;
			}else {
				stored = tableManager.getTable().getValue(key);
				if (null != stored) {
					value = stored.toString();
				}else{
					value = "NF";
				}
				
				builder.append(message + "\t" + value + "\n");
			}
			
		}//for
		
		this.setText(this.builder.toString());
		
	}//printhashmap

	@Override
	public void onConnect() {
		this.setBackground(ReferenceData.getInstance().activeColor);
	}

	@Override
	public void onDisconnect() {
		this.setBackground(ReferenceData.getInstance().inactiveColor);
	}
	
	

}//class
