package thomas.a08;

import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Schaltjahr {

	public boolean istSchaltjar(int jahr) {

		return (jahr % 400 == 0 || (jahr % 4 == 0 && jahr % 100 != 0));

	}

	public void getSchaltjahre(String startjahr, int limit) {
		LocalDate jahr = LocalDate.parse(startjahr);

		Predicate<LocalDate> schaltJahr = (s) -> istSchaltjar(s.getYear());

		Supplier<Stream<LocalDate>> schaltjahre = () -> Stream.iterate(jahr, x -> x.plusYears(1));
		schaltjahre.get().filter(schaltJahr).limit(limit).forEach(System.out::println);
		

	}

	public static void main(String[] args) {
		Schaltjahr  sj= new Schaltjahr();
		sj.getSchaltjahre("2016-06-16", 20);
		

	}
}
