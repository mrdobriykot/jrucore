package settings;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class EatChanceTable {
    private static Map<String, Map<String, Double>> eatChanceTable;

    static {
        try {
            eatChanceTable = new Gson().fromJson(Files.newBufferedReader(
                    Path.of("src/configfiles/","luck.json")), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e + " " + "File luck.json is incorrect or not found");
        }
    }

    public static Map<String, Map<String, Double>> getEatChanceTable() {
        return eatChanceTable;
    }
}
