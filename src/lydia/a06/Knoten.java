package lydia.a06;

public class Knoten<E> {
	
	E nachfolger;
	E element;

	public Knoten(E nachfolger, E element) {
		this.nachfolger = nachfolger;
		this.element = element;
	}

	private E getNachfolger() {
		return nachfolger;
	}

	private void setNachfolger(E nachfolger) {
		this.nachfolger = nachfolger;
	}
	
	

}
