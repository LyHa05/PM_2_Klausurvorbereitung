package thomas.a03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.WrongMethodTypeException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Leser {
	private Path pfad;
	private Map<String, String> daten = new HashMap<>();
	private List<String> zeile;
	private File file;

	public Leser(String datei) throws IOException {
		pfad = Paths.get(datei);
		file = new File(datei);
		zeile = Files.lines(pfad).collect(Collectors.toList());
		for (String zeile : zeile) {
			String[] zeilenArray = zeile.split("=");
			daten.put(zeilenArray[0].trim(), zeilenArray[1].trim());
		}

	}

	public String getValue(String property) {
		String ausgabe = daten.get(property);
		if (ausgabe == null) {
			throw new NoSuchElementException("Element nicht vorhanden");
		}
		return ausgabe;
	
	}

	public Integer getIntValue(String property) {
		int zahl;
		try {
			zahl = Integer.parseInt(daten.get(property));
		} catch (NumberFormatException e) {
			throw new WrongMethodTypeException("Wert ist kein int.");
		}
		return zahl;
	

	}

	public double getDoubleValue(String property) {
		double zahl;
		try {
			zahl = Double.parseDouble(daten.get(property));
		} catch (NumberFormatException e) {
			throw new WrongMethodTypeException();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Property nicht vorhanden.");
		}
		return zahl;

	}
	
	public void save() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(file);
		daten.forEach((k, v) -> {
			pw.println(k + "=" + v);
		});
		pw.close();
	}

	public void gib() {
		System.out.println(daten.toString());

	}

	public static void main(String[] args) throws IOException {
		Leser l = new Leser("src//thomas//a03//datei.txt");
		l.gib();

	}

}
