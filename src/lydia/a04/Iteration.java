package lydia.a04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteration {

	static List<String>  meineListe = new ArrayList<>();
	
	
	public static void befuellenDerListe() {
		meineListe.add("Hallo");
		meineListe.add("Welt");
		meineListe.add("das");
		meineListe.add("Ende");
		meineListe.add("naht");
	}
	
	public static void forNormal() {
		for (int i = 0; i < meineListe.size(); i++) {
			System.out.println(meineListe.get(i));
		}
	}
	
	public static void forKurz() {
		for (Iterator<String> iterator = meineListe.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
	}
	
	public static void forEachAlsForSchleife() {
		for (String string : meineListe) {
			System.out.println(string);
		}
	}
	
	public static void forEachAlsStreamMethodenReferenz() {
		meineListe.stream().forEach(System.out :: println);
	}
	
	public static void forEachAlsStreamLambda() {
		meineListe.stream().forEach(string -> System.out.println(string));
	}

	public static void main(String[] args) {
		befuellenDerListe();
		forNormal();
		System.out.println("________________");
		forKurz();
		System.out.println("________________");
		forEachAlsForSchleife();
		System.out.println("________________");
		forEachAlsStreamMethodenReferenz();
		System.out.println("________________");
		forEachAlsStreamLambda();
		System.out.println("________________");
	}
}
