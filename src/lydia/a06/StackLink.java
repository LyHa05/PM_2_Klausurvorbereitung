package lydia.a06;

public class StackLink<T> {

	private Stueck<T> oberstesElement;
	private Stueck<T> kopfElement;
	private int groesse;
	
	public StackLink() {
		kopfElement = null;
		oberstesElement = null;
		groesse = 0;
	}
	
	public int groesse() {
		return groesse;
	}
	
	public void push(Stueck<T> neuesElement) {
		if (oberstesElement == null) {
			oberstesElement = neuesElement;
			kopfElement = neuesElement;
			++groesse;
		} else if (oberstesElement != null) {
			Stueck<T> vorherigesOberesElement = oberstesElement;
			vorherigesOberesElement.nachfolger = neuesElement;
			oberstesElement = neuesElement;
			++groesse;
		}
	}
	
	public boolean istLeer() {
		return (oberstesElement == null);
	}
	
	public Stueck<T> pop() {
		 if (istLeer()) throw new NullPointerException("StackListe ist leer!");
		 if (oberstesElement == kopfElement) {
			oberstesElement = null;
		 	kopfElement = null;
		 } else if (oberstesElement != kopfElement) {
			 kopfElement.nachfolgerEntfernen();
		 }
		 return oberstesElement;
	}
	
	public Stueck<T> peek() {
		if (istLeer()) throw new NullPointerException("StackListe ist leer!");
		return oberstesElement;
	}
	

}
