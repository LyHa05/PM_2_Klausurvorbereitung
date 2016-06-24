package dennis.schaltjahr;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Schaltjahr {

	public static LocalDate getSchaltjahr(int abJahr){
		Supplier<Stream<LocalDate>> s = (()->Stream.iterate(LocalDate.of(abJahr, 1, 1), n->n.plusYears(1)));
		return s.get().filter(y-> ((y.getYear()%4 == 0 && y.getYear()%4 != 0) || y.getYear()%400 == 0)).findFirst().get();
		//s.get().findFirst(y-> y.year())
	}
	
	public static List<LocalDate> getSchaltjahre(int abJahr, int anzahl){
		Supplier<Stream<LocalDate>> s = (()->Stream.iterate(getSchaltjahr(abJahr), n->n.plusYears(4)));
		return s.get().limit(anzahl).collect(Collectors.toList());
	}
	
	public static void main(String[] args){
		getSchaltjahre(2016, 20).forEach(System.out::println);
	}

}
