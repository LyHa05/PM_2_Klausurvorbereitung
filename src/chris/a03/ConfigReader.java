package chris.a03;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ConfigReader {
    private HashMap<String, String> parsedConfig = new HashMap<>();
    private List<String> configFile;
    private Path pathToFile;

    ConfigReader(String path){
        this.pathToFile = Paths.get(path);
        try {
            configFile = Files.lines(pathToFile).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseConfig();
    }

    private void parseConfig(){
        for(String element : configFile){
            String[] tempArray = element.split("=");
                parsedConfig.put(tempArray[0].trim(), tempArray[1].trim());
        }
    }

    private void parseConfigLambda(){
        try {
            Files.lines(pathToFile).map(s -> {return s.replaceAll("\\s+", "");}).map(s -> s.split("="))
                    .forEach(a -> parsedConfig.put(a[0], a[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter(pathToFile.getFileName().toString());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        parsedConfig.forEach((k, v) -> pw.println(k + " = " + v));
    }

    public String getValue(String key){
        String value = parsedConfig.get(key);
        if (value == null){
            throw new NoSuchElementException("Die gesuchte Eigenschaft gibt es nicht");
        }

        return value;
    }

    public Integer getIntValue(String key){
        String value = parsedConfig.get(key);
        Integer intValue = 0;

        if (value == null){
            throw new NoSuchElementException("Die gesuchte Eigenschaft gibt es nicht");
        }
        try{
            intValue = Integer.parseInt(value);
        } catch (Exception e){
            throw new NumberFormatException("Die gesuchte Eigenschaft konnte nicht auf Integer gecastet werden");
        }

        return intValue;
    }

    public Double getDoubleValue(String key){
        String value = parsedConfig.get(key);
        Double doubleValue = 0.0;

        if (value == null){
            throw new NoSuchElementException("Die gesuchte Eigenschaft gibt es nicht");
        }
        try{
            doubleValue = Double.parseDouble(value);
        } catch (Exception e){
            throw new NumberFormatException("Die gesuchte Eigenschaft konnte nicht auf Integer gecastet werden");
        }

        return doubleValue;
    }

    public Boolean exist(String key){
        if(parsedConfig.get(key) != null) return true;
        return false;
    }

    public void setValue(String key, String value){
        parsedConfig.put(key, value);
    }

    public void setIntValue(String key, int value){
        parsedConfig.put(key, String.valueOf(value));
    }

    public void setDoubleValue(String key, int value){
        parsedConfig.put(key, String.valueOf(value));
    }

    public static void main(String[] args){
        ConfigReader cr = new ConfigReader("file.conf");
        System.out.println(cr.getValue("name"));
    }
}
