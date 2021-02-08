
public interface sujet {

	//méthodes pour attacher et détacher les "observers"
	public void register(observateurs o);
	
	public void unRegister(observateurs o);
	
	//méthode pour notifier les observateurs d'un changement
	public void notifyOb();
	
}
