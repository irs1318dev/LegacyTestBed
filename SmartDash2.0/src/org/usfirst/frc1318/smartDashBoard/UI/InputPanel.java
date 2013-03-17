package org.usfirst.frc1318.smartDashBoard.UI;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.usfirst.frc1318.smartDashBoard.ConnectionListener;
import org.usfirst.frc1318.smartDashBoard.TableManager;

import edu.wpi.first.wpilibj.tables.ITable;

public class InputPanel extends JPanel implements ActionListener, ConnectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3456407891290547726L;
	
	Checkbox override;
	ITable table;
	HashMap<String, String> fieldNames;
	HashMap<String, InputField> fields;
	Button submitButton;
	String overrideKey;
	
	/**
	 * This is a semi-generic class that updates values in an ITable based on 
	 * user input into text fields
	 * 
	 * 
	 * @param fieldNames
	 * 		a hashmap with keys being keys from the ITable, and values being 
	 * 		the name of the field to show up in the gui
	 */
	public InputPanel(HashMap<String, String> fieldNames, String overrideKey) {
		this.table = TableManager.getInstance().getTable();
		this.fieldNames = fieldNames;
		this.fields = new HashMap<String, InputField>();
		this.overrideKey = overrideKey;
		
		
		//make panels show up in correct layout
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		override = new Checkbox("Override");
		override.setState(false);
		this.add(override);
		
		//create input fields for all values
		for(String s : fieldNames.keySet()) {
			InputField newField = new InputField(fieldNames.get(s), this);
			this.add(newField);
			fields.put(s, newField);
		}
		
		//make button work
		submitButton = new Button("Send to Robot");
		submitButton.addActionListener( this );
		
		this.add(submitButton);
		
		TableManager.getInstance().addListener(this);
	}
	/**
	 * called on click of submitButton
	 * 
	 * this puts values from fields into itable as the (hopefully) correct types
	 *
	 * @Override
	 */
	public void actionPerformed(ActionEvent e) {
		
		table.putBoolean(overrideKey, override.getState());
		
		//loop through all fields
		for( String s : fields.keySet()) {
			
			//Make sure type is correct and put into itable
			
			//Number
			if (table == null) {
				
				System.out.println("Table has not been initialized");
				
			} else if (table.getValue(s) == (null)) {
				
				System.out.println("value at " + s + " does not exist!");
				
			}else if(table.getValue(s).getClass().equals( Double.class)) {
				
				table.putNumber(s, Double.parseDouble(fields.get(s).getText()));
				
			//Boolean
			}else if ( table.getValue(s).getClass() == Boolean.class ) {
				
				table.putBoolean(s, Boolean.parseBoolean(fields.get(s).getText()));
			
			//String
			}else if (table.getValue(s).getClass() == String.class) {
				
				table.putString(s, fields.get(s).getText());
				
			//Other
			}else{
				
				System.out.println("error: Type control in class InputPanel or nonexistant key");
				
			}//i/e
				
		}//f
		
		System.out.println("Table updated from InputPanel");
		
	}//m
	@Override
	public void onConnect() {
		this.submitButton.setEnabled(true);
		this.table = TableManager.getInstance().getTable();
		
	}
	@Override
	public void onDisconnect() {
		this.submitButton.setEnabled(false);
		
	}

}//c
