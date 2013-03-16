package org.usfirst.frc1318.smartDashBoard.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.usfirst.frc1318.smartDashBoard.constants.ReferenceData;

import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

public class NTPanel  extends JPanel  {

	public NTPanel(JFrame frame) {
		this.setPreferredSize(new Dimension(frame.getWidth() / 5, frame.getWidth()));
		this.setBackground(ReferenceData.getInstance().disabledColor);
		this.setForeground(Color.white);
		
		if(false != ReferenceData.getInstance().NTPanelEnabled) {
			this.initialize();
			this.start();
		}
	}
	
	private void initialize() {
		
	}
	
	private void start() {
		
	}


}
