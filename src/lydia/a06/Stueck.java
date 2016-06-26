package lydia.a06;

public class Stueck<T> {
	
	Stueck<T> nachfolger;
	T daten;

	public Stueck(Stueck<T> nachfolger, T daten) {
		this.nachfolger = nachfolger;
		this.daten = daten;
	}
	
	public Stueck(T daten) {
		this.nachfolger = null;
		this.daten = daten;
	}
	
	public void nachfolgerEntfernen() {
		if (nachfolger.getNachfolger() == null) {
				nachfolger = null;
		} else if (nachfolger.getNachfolger() != null) {
			nachfolger.nachfolgerEntfernen();
		}
	}

	
	
	public Stueck<T> getNachfolger() {
		return nachfolger;
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
		Stueck<T> other = (Stueck<T>) obj;
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
