import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Ja {

	private JFrame frame;
	private JLabel Unit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ja window = new Ja();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void setUnitPosition()
	{
		Unit.setBounds(0, (frame.getSize().height/2 - 190/2), 82, 117);
	}
	
	private int getSoldierHeightCenter()
	{
		return Unit.getBounds().y+Unit.getBounds().height/20;
	}
	
	private void initialize() {
		JPanel panel = new JPanel();
		final JPanel area = new JPanel();
		ButtonGroup buttonGroup = new ButtonGroup();
		final JRadioButton smallWeapon = new JRadioButton("laser");
		final JRadioButton bigWeapon = new JRadioButton("pociski plazmowe");
		Unit = new JLabel("");
		frame = new JFrame();
		
		JLabel lblNewLabel_1 = new JLabel("Wybierz bro\u0144:");
		
		Unit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JComponent weapon = null;
				if(smallWeapon.isSelected())
				{
					weapon = new JLabel("====");
					weapon.setForeground(Color.CYAN);
				}
				else if(bigWeapon.isSelected())
				{
					weapon = new JButton();
					weapon.setBackground(Color.CYAN);
					weapon.setBorder(null);
				}
				weapon.setBounds(82, getSoldierHeightCenter(), 50, 25);
				area.add(weapon);
				frame.repaint();
				Bullet bullet = new Bullet(weapon,area);
				bullet.start();
			}
		});
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				setUnitPosition();
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		smallWeapon.setSelected(true);
		
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		
		panel.add(lblNewLabel_1);
		

		
		buttonGroup.add(smallWeapon);
		panel.add(smallWeapon);
		

		buttonGroup.add(bigWeapon);
		panel.add(bigWeapon);
		
		
		area.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(area, BorderLayout.CENTER);
		area.setLayout(null);
		
		Unit.setIcon(new ImageIcon(Ja.class.getResource("/images/mage.png")));
		Unit.setBounds(0, 55, 82, 117);
		area.add(Unit);
	}
}
