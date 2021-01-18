import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			JFrame frame = new JFrame("Question 3");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			panel2.setLayout(new GridLayout(2,1,20,20));
			panel3.setLayout(new FlowLayout());
			panel.setLayout(new GridLayout(1,3,20,20));
			
			panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
			panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
			panel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
			
			JLabel label = new JLabel("0");
			label.setPreferredSize(new Dimension(80,80));
			label.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
			label.setOpaque(true);
			label.setBackground(Color.black);
			label.setForeground(Color.white);
			label.addMouseListener(new CustomMouseListner(label));

			
			JLabel label2 = new JLabel("0");
			label2.setPreferredSize(new Dimension(100,100));
			label2.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
			label2.setOpaque(true);
			label2.setBackground(Color.green);
			label2.setForeground(Color.white);
			label2.addMouseListener(new CustomMouseListner(label2));
			
			JLabel label3 = new JLabel("0");
			label3.setPreferredSize(new Dimension(100,100));
			label3.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
			label3.setOpaque(true);
			label3.setBackground(Color.blue);
			label3.setForeground(Color.white);
			label3.addMouseListener(new CustomMouseListner(label3));
			
			JLabel label4 = new JLabel("0");
			label4.setPreferredSize(new Dimension(100,100));
			label4.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
			label4.setOpaque(true);
			label4.setBackground(Color.red);
			label4.setForeground(Color.white);
			label4.addMouseListener(new CustomMouseListner(label4));
			
			label.setVerticalAlignment(JLabel.BOTTOM);
			label.setHorizontalAlignment(JLabel.CENTER);
			label2.setVerticalAlignment(JLabel.BOTTOM);
			label2.setHorizontalAlignment(JLabel.CENTER);
			label3.setVerticalAlignment(JLabel.BOTTOM);
			label3.setHorizontalAlignment(JLabel.CENTER);
			label4.setVerticalAlignment(JLabel.BOTTOM);
			label4.setHorizontalAlignment(JLabel.CENTER);

			panel.add(panel3);
			panel3.add(label);
			panel.add(panel2);
			panel2.add(label2);
			panel2.add(label3);
			panel.add(label4);
			
			
			frame.setSize(350, 350); 
			frame.add(panel);	
			frame.setVisible(true);
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		}

	}
	
	static class CustomMouseListner extends MouseAdapter {
	    JLabel label;
	    
	    CustomMouseListner(JLabel label) {
	        this.label = label;
	    }
	    
	    public void mouseClicked(MouseEvent e)  
	    {  
	    	label.setText((Integer.parseInt(label.getText())+1)+"");
	    }  
	}

}
