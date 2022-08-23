package settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Getter
@Setter
@ToString
public class Settings {
    public int weight;
    public int height;


    public static Settings initialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        Settings settings;
        try {
            settings = objectMapper.readValue(Files.newBufferedReader(Path.of("src/configfiles/","settings.json")), Settings.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e + " Проблема с файлом settings.json. " +
                    "Check that it is in the settings root directory and matches the Settings() class");
        }
        return settings;
    }
}
