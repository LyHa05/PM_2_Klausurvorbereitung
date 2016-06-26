package lydia.a06;

public class MeineLinkedList<E> {

	private Knoten<E> letztesElement;
	
		public MeineLinkedList() {
			this.letztesElement = null;
	}
		/**Typ E bleibt sichergestellt, da neuerKnoten vom Typ E sein muss*/
		@SuppressWarnings("unchecked")
		public void add(E element) {
			if(letztesElement == null) {
				Knoten<E> start = new Knoten<E>(null, element);
				letztesElement = start;
			} else if (letztesElement != null) {
				Knoten<E> neuerKnoten = new Knoten<E>(null, element);
				letztesElement.nachfolger = (E) neuerKnoten;				
			}
		}
		
		public void remove(E element) {
			if (element.nachfolger == null) {
				
			}
		}
			
}
