import javax.swing.JLabel;

public class CompteurPubsConcrete extends JLabel implements observateurs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int cont;
	 
	public CompteurPubsConcrete() {
		super("Nombre de pubs présentées: 0.");
		cont = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		cont ++;
		this.setText("Nombre de pubs présentées: " + cont + ".");
	}


}
