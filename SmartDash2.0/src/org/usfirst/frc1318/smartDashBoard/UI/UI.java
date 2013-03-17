package org.usfirst.frc1318.smartDashBoard.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
	}
	
	public void addInputPanels() {
		HashMap <String, String> panel1Names = new HashMap<String, String>();
		
		panel1Names.put("s.sp", "Shooter Setpoint");
		
		this.ntpanel.add(new InputPanel(panel1Names));
	}
	
}
