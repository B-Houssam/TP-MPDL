import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JFrame frame = new JFrame("Question 4");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			//Create the menu bar.
			JMenuBar menuBar = new JMenuBar();

			//Build the first menu.
			JMenu menu = new JMenu("Fichier");
			JMenu menu2 = new JMenu("Edition");
			
			menuBar.add(menu2);
			menuBar.add(menu);
			
			JMenuItem menuItem = new JMenuItem("Ouvrir");
			JMenuItem menuItem2 = new JMenuItem("Sauver");
			JMenuItem menuItem3 = new JMenuItem("Quiter");
			
			menu2.add(menuItem);
			menu2.add(menuItem2);
			menu2.addSeparator();
			menu2.add(menuItem3);
			
			menuItem3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String ObjButtons[] = {"Yes","No"};
					int prompRes = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Online Examination System",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
					if (prompRes == JOptionPane.YES_OPTION) {
						System.exit(0);
					} 					
				}
			});
			
			
		
			//menu.add(menuItem);
			
			panel.add(menuBar, BorderLayout.NORTH);
			
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

}
