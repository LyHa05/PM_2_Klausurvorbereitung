package thomas.a06;

import java.util.NoSuchElementException;

public class Kette<T>{
	private Element first;
	private int size;
	
	
	
	private class Element {
		private T kettenElement;
		private Element next;
		
	}

	public Kette(){
		first = null;
		size = 0;
	}
	
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(T element){
		Element alteFirst = first;
		first = new Element();
		first.kettenElement = element;
		first.next = alteFirst;
		size++;
		
	}
	
	public T pop(){
		if(isEmpty()) throw new NoSuchElementException("Kette ist leer!");
		T kettenElement = first.kettenElement;
		first =first.next;
		size--;
		return kettenElement;
	}
	
	public T peek(){
		if(isEmpty()) throw new NoSuchElementException("Kette ist leer!");
		return first.kettenElement;}
	
	
	public static void main(String[] args) {
		
Kette<Integer> kette = new Kette<>();
kette.push(1);
kette.push(2);
kette.push(3);
kette.push(4);
kette.push(5);
System.out.println(kette.size());
System.out.println(kette.peek());
kette.pop();
kette.pop();
System.out.println(kette.pop());
System.out.println(kette.peek());
System.out.println(kette.size());



	}

}
