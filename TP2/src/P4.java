import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Author Bousri Houssam
 */

public class P4 {
	
	static String colorList[] = {"green", "blue", "red", "magenta", "orange"};
	
	public static String getColorN(int pos) {
		switch (pos) {
		case 0: {
			return "green";
		}
		case 1:{
			return "blue";
		}
		case 2:{
			return "red";
		}
		case 3:{
			return "magenta";
		}
		case 4:{
			return "orange";
		}
		default:
			return null;
		}
	}
	
	public static Color getColor(String col) {
		try {
			java.lang.reflect.Field field = Class.forName("java.awt.Color").getField(col); 
			return (Color)field.get(null);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JFrame frame = new JFrame("Question 4");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel(new BorderLayout());
			
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel(new BorderLayout());
			JPanel panel4 = new JPanel();
			JPanel panel5 = new JPanel();
			JPanel panel6 = new JPanel();
						
			
			panel1.setOpaque(true);
			panel1.setBackground(Color.green);
			
			SpinnerListModel m = new SpinnerListModel(colorList);	
			JSpinner js = new JSpinner(m);
			js.setPreferredSize(new Dimension(100,25));
			js.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent arg0) {
					// TODO Auto-generated method stub
					panel1.setBackground(getColor((String) js.getValue()));
				}
			});
			panel1.add(js);
			
			panel2.setOpaque(true);
			panel2.setBackground(Color.magenta);
			panel2.setBorder(BorderFactory.createTitledBorder("Panel de saisie"));
			
			JTextField tc = new JTextField();
			tc.setPreferredSize(new Dimension(150,20));
			JLabel jl = new JLabel("Color name (english)?: ");
			tc.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					panel2.setBackground(getColor(tc.getText()));
					
				}
			});
			panel2.add(jl);
			panel2.add(tc);
			
			panel4.setOpaque(true);
			panel4.setBackground(Color.blue);
			
			JComboBox<String> jc = new JComboBox<String>();
			jc.addItem(colorList[1]);
			jc.addItem(colorList[0]);
			jc.addItem(colorList[2]);
			jc.addItem(colorList[3]);
			jc.addItem(colorList[4]);
			jc.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					panel4.setBackground(getColor((String) jc.getSelectedItem()));
				}
			});
			panel4.add(jc);
			
			panel5.setOpaque(true);
			panel5.setBackground(Color.red);
			
			JSlider jss = new JSlider(JSlider.HORIZONTAL, 0,4,2);
			jss.setPreferredSize(new Dimension(350,35));
			jss.setPaintTicks(false);
			jss.setPaintLabels(true);
			jss.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent arg0) {
					// TODO Auto-generated method stub
					panel5.setBackground(getColor(getColorN(jss.getValue())));
				}
			});
			
			Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
			labelTable.put(0, new JLabel(colorList[0]));
			labelTable.put(1, new JLabel(colorList[1]));
			labelTable.put(2, new JLabel(colorList[2]));
			labelTable.put(3, new JLabel(colorList[3]));
			labelTable.put(4, new JLabel(colorList[4]));
			jss.setLabelTable( labelTable );
			
			panel5.add(jss);
			
			panel6.setOpaque(true);
			panel6.setBackground(Color.orange);
			
			ButtonGroup G1 = new ButtonGroup(); 
			JRadioButton jr1 = new JRadioButton(colorList[0]); 
			JRadioButton jr2 = new JRadioButton(colorList[1]); 
			JRadioButton jr3 = new JRadioButton(colorList[2]); 
			JRadioButton jr4 = new JRadioButton(colorList[3]); 
			JRadioButton jr5 = new JRadioButton(colorList[4]); 
			G1.add(jr1);
			G1.add(jr2);
			G1.add(jr3);
			G1.add(jr4);
			G1.add(jr5);
			
			jr5.setSelected(true);
			
			jr1.addActionListener(new Action(jr1.getActionCommand(),panel6));
			jr2.addActionListener(new Action(jr2.getActionCommand(),panel6));
			jr3.addActionListener(new Action(jr3.getActionCommand(),panel6));
			jr4.addActionListener(new Action(jr4.getActionCommand(),panel6));
			jr5.addActionListener(new Action(jr5.getActionCommand(),panel6));
			
			
			panel6.add(jr1);
			panel6.add(jr2);
			panel6.add(jr3);
			panel6.add(jr4);
			panel6.add(jr5);
			
			panel3.add(panel4, BorderLayout.WEST);
			panel3.add(panel5, BorderLayout.CENTER);
			panel3.add(panel6, BorderLayout.EAST);
			
			panel.add(panel1, BorderLayout.NORTH);
			panel.add(panel2, BorderLayout.SOUTH);
			panel.add(panel3, BorderLayout.CENTER);
			
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
	
	static class Action implements ActionListener { 
		JPanel pan;
		String col;
		public Action(String col, JPanel pan) {
			// TODO Auto-generated constructor stub
			this.col=col;
			this.pan=pan;
		}
		public void actionPerformed (ActionEvent e) {    
			pan.setBackground(getColor(col));
		}
	}

}
