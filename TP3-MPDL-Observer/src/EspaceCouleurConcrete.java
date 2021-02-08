import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class EspaceCouleurConcrete extends JPanel implements observateurs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Color couleur;
	
	public EspaceCouleurConcrete() {
		// TODO Auto-generated constructor stub
		couleur = Color.BLACK;
	}

	public void repaint(Graphics g) {
		g.setColor(couleur);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (couleur == Color.BLACK) {
			couleur = Color.BLUE;
		} else {
			couleur = Color.BLACK;
		}
		repaint(getGraphics());
	}
}
