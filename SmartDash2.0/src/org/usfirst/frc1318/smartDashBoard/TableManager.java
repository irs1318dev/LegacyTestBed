package org.usfirst.frc1318.smartDashBoard;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.smartdashboard.robot.Robot;
import edu.wpi.first.wpilibj.tables.IRemote;
import edu.wpi.first.wpilibj.tables.IRemoteConnectionListener;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;


/**
 * 
 * This class is simply a table listener that maintains a table of values
 * and provides access to this table to other classes 
 * 
 * @author Graham
 *
 */
public class TableManager implements ITableListener{
	
//singleton stuff
	private static TableManager instance;
	
	public static TableManager getInstance() {
		if(instance == null){
			instance = new TableManager();
		}
		return instance;
	}

//non-singleton stuff
	
	HashMap<String, Object> map;
	ArrayList<String> keys;
	boolean connected;
	
	private TableManager() {
		map = new HashMap<String, Object>();
		keys = new ArrayList<String>();
		
		Robot.setTeam(1318);
		Robot.addConnectionListener(new IRemoteConnectionListener()
		{
			@Override
			public void connected(IRemote arg0)
			{
				table_connected();
				System.out.println("Table Connected: " + arg0.toString());
			}

			@Override
			public void disconnected(IRemote arg0)
			{
				table_disconnected();
				System.out.println("Table Disconnected: " + arg0.toString());
			}

			
		}, true);
		Robot.getTable().addTableListener(this);
		
	}
	
	@Override
	/**
	 * adds values to hash map and updates old ones
	 * this will work with unexpected keys and display them, but they 
	 * will not be sorted
	 */
	public void valueChanged(ITable source, String key, Object value,
			boolean isNew) {
		
		if(map.get(key) == null) {
			keys.add(key);
		}
		map.put(key, value);
		
	}
	
	
//called on each event (self explanitory)
	private void table_disconnected() {
		this.connected = false;
		
	}
	
	private void table_connected() {
		this.connected = true;
		
	}
	
//Getters and setters
	public Object get(String key) {
		return map.get(key);
	}
	
	public ArrayList<String> getKeys() {
		return keys;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public HashMap<String, Object> getHashMap() {
		return map;
	}
}
