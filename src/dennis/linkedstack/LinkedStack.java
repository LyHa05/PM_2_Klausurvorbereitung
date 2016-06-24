package dennis.linkedstack;

public class LinkedStack<E> {
	private Node<E> first;
	public LinkedStack(){
		
	}
	
	public void push(E elem){
		if(first == null){
			first = new Node<E>(null, elem);
		}else{
			Node<E> n = new Node<E>(first, elem);
			first = n;
		}
	}
	
	public E pop(){
		if(first == null){
			return null;
		}
		Node<E> firstNew = first.next;
		E ausgabe = first.elem;
		first.next = null;
		first = firstNew;
		return ausgabe;
	}
	
	public int size(){
		int ausgabe = 0;
		Node<E> aktElem = first;
		while(aktElem != null){
			aktElem = aktElem.next;
			ausgabe++;
		}
		return ausgabe;
	}

	//Warum Static?
	private static class Node<E> {
		Node<E> next;
		E elem;
		Node(Node<E> next, E elem){
			this.next = next;
			this.elem = elem;
		}
	}
}
