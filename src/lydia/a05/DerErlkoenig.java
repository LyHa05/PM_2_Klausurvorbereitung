package lydia.a05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DerErlkoenig {
	
	public static File meinFile;

	public static void streamLadenUndAusgeben() throws IOException {
		try {
		meinFile = MeinFileChooser.chooseFile();
		} catch(NullPointerException e) {
			System.out.println("Keine Datei ausgewaehlt!");
		}
		List<String> woerter = Files.lines(meinFile.toPath(),Charset.forName("ISO_8859_1")).collect(Collectors.toList());

		woerter.forEach(System.out :: println);
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
	
	public static void main(String[] args) throws IOException {

		streamLadenUndAusgeben();
		System.out.println("_________________________________");
		kindZaehlen();
	}
}
