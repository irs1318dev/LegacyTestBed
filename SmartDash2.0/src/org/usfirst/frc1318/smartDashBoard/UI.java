package org.usfirst.frc1318.smartDashBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class UI extends javax.swing.JFrame implements Updatable {
	BorderLayout borderLayout;
	StatusPanel statusPanel;
	//UIDefaults uiDefaults;
	
	ArrayList<Updatable> components;
	
	int width = 800;
	int height = 600;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		UI ui = new UI();
		while(true) {
			ui.update();
		}
	}

	
	public UI() {
		super("Driver Station --- IRS 2013 --- The DeLorean	");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container pane = this.getContentPane();
		
		//this.uiDefaults = new UIDefaults();
		
		components = new ArrayList<Updatable>();
		
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
		this.setSize(800, 600);
		
		statusPanel = new StatusPanel(this);
		components.add(statusPanel);
		
		pane.add(statusPanel, BorderLayout.LINE_START);
		
		//pane.add(new JButton("TEST BUTTON"), BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void update( ) {
		for(Updatable u : components) {
			u.update();
		}
	}
	
//	public UIDefaults getUIDefaults() {
//		return this.uiDefaults;
//	}
}
