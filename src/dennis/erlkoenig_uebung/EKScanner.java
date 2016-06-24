package dennis.erlkoenig_uebung;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

import dennis.conf_uebung.MyFileChooser;

public class EKScanner {
	File f;

	public EKScanner(File f) {
		this.f = f;
	}

	public long countAllWords() throws IOException {
		return Files.lines(f.toPath(), StandardCharsets.ISO_8859_1)
				.map(s-> s.split("\\s+")).flatMap(Arrays::stream).collect(collector)
	}

	public void print() throws IOException {
		Files.lines(f.toPath(), StandardCharsets.ISO_8859_1).forEach(System.out::println);
	}

	public long countWord(String wort) throws IOException {
		return Files.lines(f.toPath(), StandardCharsets.ISO_8859_1).filter(s -> s.equals(wort)).count();
	}

	public static void main(String[] args) throws IOException {
		EKScanner ek = new EKScanner(MyFileChooser.chooseFile());
		ek.print();
		System.out.println("Der Erlkönig hat" + ek.countAllWords() + "Wörter");
		System.out.println("Das Wort Kind kommt " + ek.countWord("Kind") + " mal vor");
	}
}
