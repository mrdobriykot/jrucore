package helper;

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
    public int XSize;
    public int YSize;
    private int starve;

    private AnimalCharacteristics[] animalCharacteristics;



    public static Settings initialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        Settings settings;
        try {
            settings = objectMapper.readValue(Files.newBufferedReader(Path.of("src/configfiles/settings.json")), Settings.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return settings;
    }
}
