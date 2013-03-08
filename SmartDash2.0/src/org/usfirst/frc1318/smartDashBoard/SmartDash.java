package org.usfirst.frc1318.smartDashBoard;

import java.io.IOException;
import edu.wpi.first.smartdashboard.robot.Robot;
import edu.wpi.first.wpilibj.tables.*;
import java.awt.Color;

/**
 *
 * @author Neko
 */
@SuppressWarnings("serial")
public class SmartDash extends javax.swing.JFrame implements ITableListener
{
	public static final int MaxShooterSpeed = 20000;
	public static void notMain(String args[])
	{
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
				.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(SmartDash.class.getName()).log(
				java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(SmartDash.class.getName()).log(
				java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(SmartDash.class.getName()).log(
				java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(SmartDash.class.getName()).log(
				java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					new SmartDash().setVisible(true);
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel shooterEncoder;
    private javax.swing.JPanel shooterEncoderBar;
    private javax.swing.JTextArea shooterLifterStatus;
    private javax.swing.JLabel shooterSetPoint;
    private javax.swing.JPanel shooterSetpointBar;
    // End of variables declaration//GEN-END:variables
	public SmartDash() throws IOException
	{
		Robot.setTeam(1318);
		initComponents();
		this.setTitle("Smart DashBoard");
		Robot.addConnectionListener(new IRemoteConnectionListener()
		{
			@Override
			public void connected(IRemote arg0)
			{
				table_connected();
			}

			@Override
			public void disconnected(IRemote arg0)
			{
				table_disconnected();
			}
		}, true);
		Robot.getTable().addTableListener(this);
		this.setBackground(Color.BLACK);
	}

	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        shooterEncoderBar = new javax.swing.JPanel();
        shooterSetpointBar = new javax.swing.JPanel();
        shooterEncoder = new javax.swing.JLabel();
        shooterSetPoint = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shooterLifterStatus = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(961, 50));

        shooterEncoderBar.setBackground(new java.awt.Color(0, 136, 0));

        javax.swing.GroupLayout shooterEncoderBarLayout = new javax.swing.GroupLayout(shooterEncoderBar);
        shooterEncoderBar.setLayout(shooterEncoderBarLayout);
        shooterEncoderBarLayout.setHorizontalGroup(
            shooterEncoderBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        shooterEncoderBarLayout.setVerticalGroup(
            shooterEncoderBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        shooterSetpointBar.setBackground(new java.awt.Color(0, 148, 255));
        shooterSetpointBar.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout shooterSetpointBarLayout = new javax.swing.GroupLayout(shooterSetpointBar);
        shooterSetpointBar.setLayout(shooterSetpointBarLayout);
        shooterSetpointBarLayout.setHorizontalGroup(
            shooterSetpointBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        shooterSetpointBarLayout.setVerticalGroup(
            shooterSetpointBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        shooterEncoder.setText("Shooter Encoder: 20000");
        shooterEncoder.setAutoscrolls(true);

        shooterSetPoint.setText("Shooter Setpoint: 20000");
        shooterSetPoint.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shooterSetpointBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shooterEncoderBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(309, 309, 309)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shooterEncoder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shooterSetPoint, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shooterEncoderBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shooterEncoder, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shooterSetpointBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(shooterSetPoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        shooterEncoder.getAccessibleContext().setAccessibleName("shooter encoder");

        jPanel2.setBackground(new java.awt.Color(50, 50, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 961, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        shooterLifterStatus.setEditable(false);
        shooterLifterStatus.setBackground(new java.awt.Color(0, 0, 0));
        shooterLifterStatus.setColumns(20);
        shooterLifterStatus.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        shooterLifterStatus.setForeground(new java.awt.Color(255, 255, 255));
        shooterLifterStatus.setRows(5);
        shooterLifterStatus.setText("Shooter: Up\nLifter:  Down");
        shooterLifterStatus.setToolTipText("");
        shooterLifterStatus.setBorder(null);
        shooterLifterStatus.setFocusable(false);
        jScrollPane1.setViewportView(shooterLifterStatus);
        shooterLifterStatus.getAccessibleContext().setAccessibleName("shooterLifterstatus");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(655, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void table_connected()
	{
		
	}

	public void table_disconnected()
	{
		
	}

	public void table_feild_added(String key, Object value)
	{
		
	}

	@Override
	public void valueChanged(ITable source, String key, Object value,
		boolean isNew)
	{
		if(key.equals(NTRef.Shooter_SetPoint))
		{
			double setPoint = Robot.getTable().getNumber(key);
			shooterSetPoint.setText("Shooter Setpoint: " + Math.floor(setPoint + 0.5));
			shooterSetpointBar.setBounds(0, 25, (int)((1.0/(setPoint)) * 960 ), 25);
		}
		else if (key.equals(NTRef.Shooter_AngularEncoderSpeed))
		{
			double encoder = Robot.getTable().getNumber(key);
			shooterEncoder.setText("Shooter Encoder: " + encoder);
			shooterSetpointBar.setBounds(0, 0, (int)((MaxShooterSpeed/(encoder)) * 960 ), 25);
		}
		else if (key.equals(NTRef.Solenoid_LifterUp) || key.equals(NTRef.Solenoid_ShooterUp))
		{
			String str = "";
			if(Robot.getTable().getBoolean(NTRef.Solenoid_ShooterUp))
				str += "Shooter: UP\n";
			else
				str += "Shooter: DOWN\n";
			if(Robot.getTable().getBoolean(NTRef.Solenoid_LifterUp))
				str += "Lifter:  UP";
			else
				str += "Lifter:  DOWN";
			shooterLifterStatus.setText(str);
		}
	}
}