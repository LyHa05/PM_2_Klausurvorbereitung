package chris.a05;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EKParser {
    private Path pathToFile;

    EKParser(String path){
        pathToFile = Paths.get(path);
    }

    public void startenParser(){
        // Hier werden alle Methoden aufgerufen
        System.out.println("File gewaehlt.");
    }

}
