package lydia.a07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterationMitInteger {

	static List<Integer> integerList = new ArrayList<>(); 
	
	
	public static void befuellen() {
		integerList.add(200_000_000);
		integerList.add(502_459_929);
		integerList.add(3);
		integerList.add(146);
	}
	
	public static int summe() throws IntegerOverflowException {
		int ergebnis = 0;
		
		for (int i = 0; i < integerList.size(); i++) {

			
			try {
				ergebnis = Math.addExact(ergebnis, integerList.get(i));
			} catch (ArithmeticException e) {
				throw new IntegerOverflowException("Integerbereich ueberschritten");
			}
			
		}
		
		return ergebnis;
	}
	
	
	public static int mittelwert() throws IntegerOverflowException {
		int ergebnis = 0;
		
		for (Iterator<Integer> iterator = integerList.iterator(); iterator.hasNext();) {
		
			try {
				ergebnis = Math.addExact(ergebnis, iterator.next());
			} catch (ArithmeticException e) {
				throw new IntegerOverflowException("Integerbereich ueberschritten");
			}
			
		}
		
		return ergebnis/integerList.size();
	}
	
	public static int absoluteKleinsteDifferenz() throws IntegerOverflowException {
		int kleinsteDifferenz = Integer.MAX_VALUE;
		int differenz = 0;
		
		try {
			for (int i = 0; i < integerList.size() - 1; i++) {
				differenz = Math.abs(Math.subtractExact(integerList.get(i), integerList.get(i+1)));
				if (differenz < kleinsteDifferenz) {
					kleinsteDifferenz = differenz;
				}
			}
		} catch (ArithmeticException e) {
			throw new IntegerOverflowException("Integerbereich ueberschritten");
		}
		return kleinsteDifferenz;
		
		
	}
	
		public static void main(String[] args) throws IntegerOverflowException {
			befuellen();
			System.out.println(absoluteKleinsteDifferenz());
			
		}
	

}
