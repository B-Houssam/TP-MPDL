
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class P extends JFrame{
	
	/**
	 * Author Bousri Houssam
	 */
	private static final long serialVersionUID = 1L;
	static JButton b1;
	static JButton b2;
	static JButton b3;

	public static void main(String[] args) {
		try {
			 JFrame frame = new JFrame("Question 2");
			  
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			  JPanel panel = new JPanel();
			  
			  panel.setLayout(new FlowLayout(FlowLayout.CENTER));
			  
			  b1 = new JButton("<html><font color=green>bouton vert</font></html>"); 
			  b1.setPreferredSize(new Dimension(130,30)); 
			  panel.add(b1);
			  
			  
			  b2 = new JButton("<html><font color=blue>bouton bleu</font></html>"); 
			  b2.setPreferredSize(new Dimension(130,30)); 
			  panel.add(b2);
			  
			  b3 = new JButton("<html><font color=green>bouton vert</font></html>"); 
			  b3.setPreferredSize(new Dimension(130,30)); 
			  panel.add(b3);
			  
			  b1.addActionListener (new Action1());
			  b2.addActionListener (new Action2());
			  b3.addActionListener (new Action3());
			  
			  frame.add(panel);
			  frame.pack();
			  frame.setVisible(true);
			  
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		}
	}
	
	static class Action1 implements ActionListener {   
		public void actionPerformed (ActionEvent e) {    
			if (b2.isEnabled() == true) {
				b2.setEnabled(false);
			}else {
				b2.setEnabled(true);
			}
		}
	}

	static class Action2 implements ActionListener {   
		public void actionPerformed (ActionEvent e) {    
			if (b1.isEnabled() == true) {
				b1.setEnabled(false);
			}else {
				b1.setEnabled(true);
			}
		}
	}

	static class Action3 implements ActionListener {   
		public void actionPerformed (ActionEvent e) {    
			System.exit(0);
		}
	}
	
}

