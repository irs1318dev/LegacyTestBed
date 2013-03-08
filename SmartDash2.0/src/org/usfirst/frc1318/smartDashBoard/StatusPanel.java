package org.usfirst.frc1318.smartDashBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class StatusPanel extends JTextArea implements Updatable {
	StringBuilder builder;
	TableManager tableManager;
	KeyHandeler keyHandeler;

	
	
	public StatusPanel(JFrame frame){
		super();
		this.setEditable(false);
		
		this.setForeground(frame.getForeground());
		this.setBackground(frame.getBackground());
		
		this.setAutoscrolls(false);
		
		this.setPreferredSize(new Dimension(frame.getWidth() * 2 / 7, 
				frame.getHeight()));
		
		keyHandeler = KeyHandeler.getInstance();
		builder = new StringBuilder();
		tableManager = TableManager.getInstance();
		
		//timer.start();
		
	}

	@Override
	public void update() {
		
		if(tableManager.isConnected() == true) {
			this.setBackground(new Color(0, 128, 64));
		}else {
			this.setBackground(new Color(128, 0, 64));
		}
		
		this.printHashMap();
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
				stored = tableManager.get(key);
				if (null != stored) {
					value = stored.toString();
				}else{
					value = "NF";
				}
				
				builder.append(message + "\t" + value + "\n");
			}
			
		}//for
		
		this.setText(this.builder.toString());
		this.invalidate();
		
	}//printhashmap
	
	

}//class
