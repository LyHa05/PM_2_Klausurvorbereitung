package lydia.a06;

public class Element<T> {

	Element<T> nachfolger;
	T daten;
	
	public Element(T elementDaten, Element<T> nachfolger) {
		this.nachfolger = nachfolger;
		daten = elementDaten;
	}
	
	public Element(T elementDaten) {
		nachfolger = null;
		daten = elementDaten;
	}
	

	public void elementNachElementAnfuegen(Element<T> neuesElement, Element<T> elementNachDemEingefuegtWird) {
		if(elementNachDemEingefuegtWird.getNachfolger() == null) {
			elementNachDemEingefuegtWird.nachfolgerAnfuegen(neuesElement);
		} else if (elementNachDemEingefuegtWird.getNachfolger() != null) {
			Element<T> NachfolgerFuerNeuesElement = elementNachDemEingefuegtWird.getNachfolger();
			elementNachDemEingefuegtWird.nachfolgerAnfuegen(neuesElement);
			neuesElement.nachfolgerAnfuegen(NachfolgerFuerNeuesElement);
			
		}
	}
	
	public void letztesElementLoeschen() {
		if (nachfolger.getNachfolger() == null) {
			nachfolger = null;
		} else if (nachfolger.getNachfolger() != null) {
			nachfolger.letztesElementLoeschen();
		}
		
	}
	
	Element<T> getNachfolger() {
		return nachfolger;
	}

	void setNachfolger(Element<T> neuerNachfolger) {
		if (nachfolger == null) {
			nachfolger = neuerNachfolger;
		} else if (nachfolger != null) {
			nachfolger.getNachfolger().setNachfolger(neuerNachfolger);
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((daten == null) ? 0 : daten.hashCode());
		result = prime * result + ((nachfolger == null) ? 0 : nachfolger.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Element<T> other = (Element<T>) obj;
		if (daten == null) {
			if (other.daten != null) {
				return false;
			}
		} else if (!daten.equals(other.daten)) {
			return false;
		}
		if (nachfolger == null) {
			if (other.nachfolger != null) {
				return false;
			}
		} else if (!nachfolger.equals(other.nachfolger)) {
			return false;
		}
		return true;
	}

	

}
