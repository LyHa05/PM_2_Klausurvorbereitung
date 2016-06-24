package dennis.conf_uebung;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.WrongMethodTypeException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Parser {
	private Map<String, String> daten = new HashMap<>();
	private File f;

	public Parser(File f) throws IOException {
		this.f = f;
		parse(f);
	}

	public String getValue(String property) {
		String ausgabe = daten.get(property);
		if (ausgabe == null) {
			throw new NoSuchElementException("Element nicht vorhanden");
		}
		return ausgabe;
	}

	public int getIntValue(String property) {
		int val;
		try {
			val = Integer.parseInt(daten.get(property));
		} catch (NumberFormatException e) {
			throw new WrongMethodTypeException("Wert ist kein int.");
		}
		return val;
	}

	public double getDoubleValue(String property) {
		double val;
		try {
			val = Double.parseDouble(daten.get(property));
		} catch (NumberFormatException e) {
			throw new WrongMethodTypeException();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("Property nicht vorhanden.");
		}
		return val;
	}

	public boolean exists(String property) {
		return daten.containsKey(property);
	}

	public void setValue(String property, String value) {
		daten.put(property, value);
	}

	public void setValue(String property, int value) {
		daten.put(property, String.valueOf(value));
	}

	public void setValue(String property, double value) {
		daten.put(property, String.valueOf(value));
	}

	public void save() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(f);
		daten.forEach((k, v) -> {
			pw.println(k + "=" + v);
		});
		pw.close();
	}

	private void parse(File f) throws IOException {
		Files.lines(f.toPath()).map(s -> {return s.replaceAll("\\s+", "");}).map(s -> s.split("="))
				.forEach(a -> daten.put(a[0], a[1]));
	}
}
