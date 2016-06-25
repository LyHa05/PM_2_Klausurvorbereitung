package thomas.a05;

import java.io.File;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileOeffner extends Application {
	private static File file;

	@Override
	public void start(Stage stage) throws Exception {
		FileChooser fileChooser = new FileChooser();
		file = fileChooser.showOpenDialog(stage);
		
		stage.show();
		stage.close();
	}

	public static File getFile() {
		file = null;
		FileOeffner.launch();
		return file;
	}
	
}
