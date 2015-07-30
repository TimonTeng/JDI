package cn.teng.jdi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JDIFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4987084502800173893L;
	
	
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 450;
	
	
	public JDIFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationRelativeTo(null);
		
		JButton b = new JButton();
		b.setText("submit");;
//		ButtonModel m = b.getModel();
		
		
		
		JPanel p = new JPanel();
//		p.setSize(0, 500);
		p.setBackground(new Color(81, 81, 79));
		 
		p.add(b);
		this.add(p, BorderLayout.SOUTH);
		
		
		JDITabPanel jdiTabPanel = new JDITabPanel();
		
		JLabel label1 = new JLabel("Tab #1", new ImageIcon(),  
                SwingConstants.CENTER); 
		label1.setVerticalTextPosition(SwingConstants.BOTTOM);  
        label1.setHorizontalTextPosition(SwingConstants.CENTER);  
        label1.setOpaque(true);  
        label1.setBackground(Color.white);  
        jdiTabPanel.addTab("Tab #1", label1);
        
		JLabel label2 = new JLabel("Tab #2", new ImageIcon(),  
                SwingConstants.CENTER); 
		label2.setVerticalTextPosition(SwingConstants.BOTTOM);  
        label2.setHorizontalTextPosition(SwingConstants.CENTER);  
        label2.setOpaque(true);  
        label2.setBackground(Color.white);  
        jdiTabPanel.addTab("Tab #2", label2);
        
		this.add(jdiTabPanel, BorderLayout.CENTER);
		
		
	}
 
}
