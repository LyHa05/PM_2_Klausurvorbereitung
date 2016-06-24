package lydia.a03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class KonfigLeser {

	private Path dateiPfad;
	private List<String> geleseneZeilen;
	private Map<String, String> configWerte = new HashMap<>();

	public KonfigLeser(String dateiName) throws IOException {

		dateiPfad = Paths.get(dateiName);
		geleseneZeilen = Files.lines(dateiPfad).collect(Collectors.toList());
		for (String zeile : geleseneZeilen) {
			String[] zeilenArray = zeile.split("=");
			configWerte.put(zeilenArray[0].trim(), zeilenArray[1].trim());
		}
	}

	public String getValue(String property) {
		pruefenObWertExisitiert(property);

		return configWerte.get(property);

	}

	public int getIntValue(String property) throws MeineException {
		pruefenObWertExisitiert(property);
		try {
			return Integer.parseInt(configWerte.get(property));
		} catch (NumberFormatException nfe) {
			throw new MeineException("Wert kann nicht in einen Interger umgewandelt werden.");
		}
	}

	public double getDoubleValue(String property) throws MeineException {
		pruefenObWertExisitiert(property);
		try {
			return Double.parseDouble(configWerte.get(property));
		} catch (NumberFormatException nfe) {
			throw new MeineException("Wert kann nicht in Double umgewandelt werden.");
		}

	}

	public boolean exists(String property) {
		return configWerte.containsKey(property);
	}

	public void pruefenObWertExisitiert(String property) {
		if (!exists(property)) {
			throw new NoSuchElementException("Element existiert nicht!");
		}
	}

	public void setValue(String property, String value) {
		configWerte.replace(property, configWerte.get(property), value);
	}

	public void setValue(String property, int value) {
		configWerte.replace(property, configWerte.get(property), String.valueOf(value));
	}

	public void setValue(String property, double value) {
		configWerte.replace(property, configWerte.get(property), String.valueOf(value));
	}

	public void save() throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(dateiPfad.toFile());
		
		configWerte.forEach((k,v) -> pw.println(k + "=" + v)); 
		
		pw.close();
	}

	public static void main(String[] args) throws IOException, MeineException {
		KonfigLeser kl = new KonfigLeser("configDateiVonLydia.txt");
		System.out.println(kl.configWerte);
		System.out.println(kl.getIntValue("a"));
		System.out.println(kl.getValue("c"));
		kl.setValue("a", "Birne");
		kl.save();
		
	}
}
