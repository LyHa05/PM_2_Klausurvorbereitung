package thomas.a05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDatei {
	private static File file;
	private Stream<String> stream;

	public void streamLaden() throws IOException {
		try {
			file = FileOeffner.getFile();
			stream = Files.lines(file.toPath(), Charset.forName("ISO_8859_1"));
		} catch (NullPointerException e) {
			System.out.println("Keine Datei ausgewaehlt!");
		}

	}

	public void printStream() throws IOException {
		stream.forEach(System.out::println);
		stream = Files.lines(file.toPath(), Charset.forName("ISO_8859_1"));
	}

	public void woerterAnzahl() {
		System.out.print("Wörternzahl: ");
		System.out.println(stream.map(e -> e.replaceAll("[^0-9A-Za-zÜüÖöÄäß ]", ""))
				.flatMap(e -> Stream.of(e.split(" "))).count());

	}

	public void woerterInHashMap() throws IOException {
		stream = Files.lines(file.toPath(), Charset.forName("ISO_8859_1"));
		Map<Object, Integer> woerter = stream.map(line -> line.split(" ")).map(stringArray -> {
			String[] neuesStringArray = new String[stringArray.length];
			for (int i = 0; i < stringArray.length; i++) {
				neuesStringArray[i] = stringArray[i].toString().replaceAll("[^0-9a-zA-ZäüöÄÜÖß]", "").toLowerCase();
			}
			return neuesStringArray;
		}).flatMap(Arrays::stream).filter(s -> !s.isEmpty())
				.collect(Collectors.groupingBy(stream -> stream.toString(), Collectors.summingInt(s -> 1)));
		System.out.println(woerter);
	}
	
	
	public void buchstabenZaehlenMitWortStream() throws IOException {
		stream = Files.lines(file.toPath(), Charset.forName("ISO_8859_1"));
		Map<String, Integer> buchstaben = stream.map(string -> string.split(""))
				.flatMap(Arrays::stream)
				.map(string -> string.replaceAll("[^0-9a-zA-ZäüöÄÜÖß]",""))
				.filter(s -> !s.isEmpty())
				.collect(Collectors.groupingBy(string -> string, Collectors.summingInt(string -> 1)));
		System.out.println(buchstaben);
	}

	public static void main(String[] args) throws IOException {
		StreamDatei sd = new StreamDatei();

		sd.streamLaden();
		sd.printStream();
		System.out.println("-------------------");
		sd.woerterAnzahl();
		sd.woerterInHashMap();
		sd.buchstabenZaehlenMitWortStream();

	}

}
