package chris.a05;

import java.io.File;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileChooserEK extends Application {
    private static File file;

    @Override
    public void start(Stage stage) throws Exception {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("*.txt"));
        file = fc.showOpenDialog(stage);

        stage.show();
        stage.close();
    }

    public static File chooseFile() {
        file = null;
        FileChooserEK.launch();
        return file;
    }

    public static void main(String[] args) {
        String path = FileChooserEK.chooseFile().getAbsolutePath();
        new EKParser(path).startenParser();
    }
}
