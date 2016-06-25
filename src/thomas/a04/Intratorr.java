package thomas.a04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Intratorr {
	private List<String> liste = new ArrayList<>();

	public void listeBefuellen() {
		liste.add("Huhu");
		liste.add("Hi");
		liste.add("Hallo");
		liste.add("Hello");

	}

	public void interation1() {
		for (String s : liste) {
			System.out.println(s);
		}
	}

	public void interation2() {
		for (int i = 0; i < liste.size(); i++) {
			System.out.println(liste.get(i));
		}
	}

	public void interation3() {
		for (Iterator<String> iterator = liste.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
	}

	public void interation4() {
		Iterator<String> interator = liste.iterator();
		while (interator.hasNext()) {
			System.out.println(interator.next());
		}
	}

	public void interation5() {
		liste.stream().forEach(System.out::println);
	}

	public void interation6() {
		liste.stream().forEach(e -> {
			System.out.println(e);
		});
	}

	public static void main(String[] args) {
		Intratorr a = new Intratorr();
		a.listeBefuellen();
		System.out.println("1-----------------------------------------------");
		a.interation1();
		System.out.println("2-----------------------------------------------");
		a.interation2();
		System.out.println("3-----------------------------------------------");
		a.interation3();
		System.out.println("4-----------------------------------------------");
		a.interation4();
		System.out.println("5-----------------------------------------------");
		a.interation5();
		System.out.println("6-----------------------------------------------");
		a.interation6();
		
	}

}
