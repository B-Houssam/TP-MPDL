import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;


public class CyclesConcrete extends JFrame implements sujet, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList observateurs;
	Timer t;
	EspaceCouleurConcrete ec;
	CompteurPubsConcrete cp;

	public CyclesConcrete() {
		// TODO Auto-generated constructor stub
		this.observateurs = new ArrayList();
		t = new Timer(2000,this);
		ec = new EspaceCouleurConcrete();
		cp = new CompteurPubsConcrete();
		register(cp);
		register(ec);
		this.setTitle("Cycles-observer");
		this.setBounds(10, 40, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		BorderLayout b1 = new BorderLayout();
		c.setLayout(b1);
		c.add(this.ec, BorderLayout.CENTER);
		c.add(this.cp, BorderLayout.NORTH);
		this.setVisible(true);
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclesConcrete f = new CyclesConcrete();
		f.t.start();
	}

	@Override
	public void register(observateurs o) {
		// TODO Auto-generated method stub
		observateurs.add(o);
	}
	
	@Override
	public void unRegister(observateurs o) {
		// TODO Auto-generated method stub
		observateurs.remove(o);
	}

	
	@Override
	public void notifyOb() {
		// TODO Auto-generated method stub
		for (Object obj : observateurs) {
			if (obj.getClass().getSimpleName() == "EspaceCouleurConcrete") {
				((EspaceCouleurConcrete) obj).update();
			} else {
				((CompteurPubsConcrete) obj).update();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		notifyOb();
	}

}
