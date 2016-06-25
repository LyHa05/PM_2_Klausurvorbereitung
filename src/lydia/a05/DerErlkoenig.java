package lydia.a05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DerErlkoenig {
	
	public static File meinFile;

	public static void streamLadenUndAusgeben() throws IOException {
		try {
		meinFile = MeinFileChooser.chooseFile();
		List<String> woerter = Files.lines(meinFile.toPath(),Charset.forName("ISO_8859_1")).collect(Collectors.toList());
		woerter.forEach(System.out :: println);
		} catch(NullPointerException e) {
			System.out.println("Keine Datei ausgewaehlt!");
		}
		
	}
	
	public static void kindZaehlen() throws IOException {
		
//replaceAll("[^0-9A-Za-z]","") -> alles außer Zahlen und Buchstaben heraus filtern
//replaceAll("[;*\\.*\\,*\\?*\\!*\\:*\\d+]", "") -> ersetzt aufgezählten Zeichen mit ""
		
		Long anzahl =  
				Files.lines(Paths.get("derErlkoenig.txt"),Charset.forName("ISO_8859_1"))
				.map(string -> string.replaceAll("[;*\\.*\\,*\\?*\\!*\\:*\\d+]", ""))
				.flatMap(line -> Stream.of(line.split(" ")))
				.filter(string -> string.contains("Kind"))
				.collect(Collectors.counting());
		System.out.println(anzahl);
		
		Long anzahl2 =  
				Files.lines(Paths.get("derErlkoenig.txt"),Charset.forName("ISO_8859_1"))
				.map(string -> string.replaceAll("[;*\\.*\\,*\\?*\\!*\\:*\\d+]", ""))
				.flatMap(line -> Stream.of(line.split(" ")))
				.filter(string -> string.contains("Kind"))
				.count();
		System.out.println(anzahl2);
		
		Long anzahl3 =  
				Files.lines(Paths.get("derErlkoenig.txt"),Charset.forName("ISO_8859_1"))
				.map(string -> string.replaceAll("[;*\\.*\\,*\\?*\\!*\\:*\\d+]", ""))
				.flatMap(line -> Stream.of(line.split(" ")))
				.filter(string -> string.equals("Kind"))
				.count();
		System.out.println(anzahl3);
	}
	
	public static void woerterInZeileDrehen() throws IOException {

		Files.lines(Paths.get("derErlkoenig.txt"), Charset.forName("ISO_8859_1"))
				.map(string -> string.split(" "))
				.map(stringArray -> {
					String[] neuesStringArray = new String[stringArray.length];
					for (int i = 0; i < stringArray.length; i++) {
						neuesStringArray[i] = stringArray[i].replaceAll("[^0-9a-zA-ZäüöÄÜÖß]", "");
					}
					return neuesStringArray;})
				.map(string -> {
					String[] neuesStringArray = new String[string.length];
					for (int i = 0; i < string.length; i++) {
						neuesStringArray[string.length - 1 - i] = string[i];
					}
					return neuesStringArray;
					})
				.map(string -> {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < string.length; i++) {
						sb.append(string[i]);
						sb.append(" ");
					}
					sb.append("\n");
					return sb.toString();
					})
				.flatMap(line -> Stream.of(line)).forEach(System.out::print);
	}
	
	public static void woerterZaehlen() throws IOException {
		Map<Object, Integer> gezaehlteWoerter = Files.lines(Paths.get("derErlkoenig.txt"), Charset.forName("ISO_8859_1"))
		.map(line -> line.split(" "))
		.map(stringArray ->
			{String[] neuesStringArray = new String[stringArray.length];
			for (int i = 0; i < stringArray.length; i++) {
				neuesStringArray[i] = stringArray[i].toString().replaceAll("[^0-9a-zA-ZäüöÄÜÖß]","").toLowerCase();
			}
			return neuesStringArray;
			}
		)
		.flatMap(Arrays::stream)
		.filter(s -> !s.isEmpty())
		.collect(Collectors.groupingBy(stream -> stream.toString(), Collectors.summingInt(s -> 1)));
		System.out.println(gezaehlteWoerter);
	}
	
	public static Stream<String> wortStream() throws IOException {
		Stream <String> wortStream = Files.lines(Paths.get("derErlkoenig.txt"),Charset.forName("ISO_8859_1"))
				.map(string -> string.split(""))
				.flatMap(Arrays::stream)
				.map(string -> string.replaceAll("[^0-9a-zA-ZäüöÄÜÖß]",""))
				.filter(s -> !s.isEmpty());
		return wortStream;
	}
	
	public static void buchstabenZaehlenMitWortStream() throws IOException {
		Map<String, Integer> gezaehlteWoerter = wortStream()
				.collect(Collectors.groupingBy(string -> string, Collectors.summingInt(string -> 1)));
		System.out.println(gezaehlteWoerter);
	}
	
	public static void wortAnzahl() throws IOException{
		long anzahl = wortStream().count();
		System.out.println(anzahl);
	}
	
	public static void main(String[] args) throws IOException {

		streamLadenUndAusgeben();
		System.out.println("_________________________________");
		kindZaehlen();
		System.out.println("_________________________________");
		woerterInZeileDrehen();
		System.out.println("_________________________________");
		woerterZaehlen();
		System.out.println("_________________________________");
		wortAnzahl();
		System.out.println("_________________________________");
		buchstabenZaehlenMitWortStream();
	}
}
