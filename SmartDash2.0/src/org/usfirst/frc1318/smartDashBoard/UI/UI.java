package org.usfirst.frc1318.smartDashBoard.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.usfirst.frc1318.smartDashBoard.constants.ReferenceData;

@SuppressWarnings("serial")
public class UI extends javax.swing.JFrame {
	BorderLayout borderLayout;
	NTPanel ntpanel;
	
	int width = 800;
	int height = 600;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReferenceData rd = ReferenceData.getInstance();
		UI.init();
		UI ui = new UI();
	}

	/**
	 * creates the user interface with all panes
	 */
	public UI() {
		super("Driver Station --- IRS 2013 --- The DeLorean	");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container pane = this.getContentPane();
		
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
		this.setSize(800, 600);
		
		ntpanel = new NTPanel(this);
		this.addInputPanels();
		
		pane.add(new StatusPanel(this), BorderLayout.LINE_START);
		pane.add(ntpanel, BorderLayout.LINE_END);
		
		if(ReferenceData.getInstance().cameraPanelEnabled) {
			//TODO make camera panel
		}
		
		this.pack();
		this.setVisible(true);
		
		//required for display
		if(ReferenceData.getInstance().statusPanel != null) {
			ReferenceData.getInstance().statusPanel.printHashMap();
		}
	}
	
	public void addInputPanels() {
		HashMap <String, String> panel1Names = new HashMap<String, String>();
		
		panel1Names.put("spid.vsp", "Shooter Setpoint");
		
		this.ntpanel.add(new InputPanel(panel1Names, "spid.nto"));
	}
	
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static boolean writeOutput = false;
	static final SimpleDateFormat sdfFile = new SimpleDateFormat("yyyy_MMdd_HH_mm_ss");
	
	public static void init() {
		if (fw == null) {
			try {
				fw = new FileWriter("c:/dashboard/recording_"+sdfFile.format(new Date())+".csv");
				bw = new BufferedWriter(fw);
				writeOutput = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	private static int  count = 0;
	private static final Object monitor = new Object();
	
	public static void writeLog(long timestamp, String output) {
		synchronized(monitor) {
		if (writeOutput) {
			try {
				bw.write(sdf.format(new Date(timestamp))+", "+output+"\n");
				if (count%100==0) {
					bw.flush();
					count = 0;
				}
				count++;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		}
	}
}
