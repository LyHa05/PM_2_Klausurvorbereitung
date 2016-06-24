package dennis.conf_uebung;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyFileChooser extends Application {
	private static File file;

	@Override
	public void start(Stage stage) throws Exception {
		FileChooser fc = new FileChooser();
//		fc.getExtensionFilters().add(new ExtensionFilter("Bilder", "*.jpg", "*.png", "*.btm", "*.tiff"));
		file = fc.showOpenDialog(stage);

		stage.show();
		stage.close();
	}

	public static File chooseFile() {
		file = null;
		MyFileChooser.launch();
		return file;
	}

	public static void main(String[] args) throws IOException {
		Parser p = new Parser(MyFileChooser.chooseFile());
		System.out.println(p.getValue("Prop1"));
		p.setValue("WertNeu", 20);
		p.setValue("Prop1", "hjf");
		p.save();
	}
}
