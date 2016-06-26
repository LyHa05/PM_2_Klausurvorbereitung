package lydia.a08;

import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class JahrStream implements Supplier<LocalDate>{
	
	private LocalDate aktuellesJahr;
	
	private JahrStream(LocalDate aktuellesJahr){
		this.aktuellesJahr = aktuellesJahr;
	}
	
	@Override
	public LocalDate get() {
		LocalDate neuesJahr = aktuellesJahr.plusYears(1);
		aktuellesJahr = neuesJahr;
		return neuesJahr;
	}

	public static Stream<LocalDate> erstellenDayStream(LocalDate startJahr, int streamLimit) {
		return(Stream.generate(new JahrStream(startJahr)).limit(streamLimit));
	}
	
	public static boolean istSchaltJahr(int jahr) {
		return (jahr % 400 == 0 || (jahr % 4 == 0 && jahr % 100 != 0));
	}
	
	
	public static void main(String[] args) {
		JahrStream.erstellenDayStream(LocalDate.parse("2000-01-01"), 30)
			.filter(jahr -> istSchaltJahr(jahr.getYear()))
			.forEach(System.out :: println);
	}
}
