package lydia.a06;

public class DieSuperLinkedList<T> {

	Element<T> kopfElement;
	
	public DieSuperLinkedList(Element<T> element) {
		kopfElement = element;
	}
	
	public DieSuperLinkedList() {
		
	}
	
	public void elementAnfuegen(Element<T> element) {
		if(kopfElement == null) {
			kopfElement = element;
		} else if (kopfElement != null) {
			kopfElement.getNachfolger().setNachfolger(element);;
		}
	}
	
	public void letztesElementLoeschen() {
		if(kopfElement == null) {
			throw new NullPointerException("Die Liste ist bereits leer.");
		} else if (kopfElement != null) {
			if (kopfElement.getNachfolger() == null) {
				kopfElement = null;
			} else if (kopfElement.getNachfolger() != null)	{
				kopfElement.getNachfolger().letztesElementLoeschen();
			}
		}
	}
		
	public void elementNachElementAnfuegen(Element<T> neuesElement, Element<T> elementNachDemEingefuegtWird) {
		if (kopfElement.equals(elementNachDemEingefuegtWird)) {
			Element<T> nachfolgerFuerNeuesElement = elementNachDemEingefuegtWird.getNachfolger();
			elementNachDemEingefuegtWird.setNachfolger(neuesElement);
			neuesElement.setNachfolger(nachfolgerFuerNeuesElement);
		} else if (!kopfElement.equals(elementNachDemEingefuegtWird))
			
	}
		
		
	}
	
	
	
	

}
