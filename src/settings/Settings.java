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
    public int width;
    public int height;

    public int starve;
    public int plantsWeight;
    private int plantsCapacityPerCell;
    private int plantsNutritionalValue;
    private String plantEmoji;

    AnimalCharacteristics[] animalCharacteristics;


    public static Settings initialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        Settings settings;
        try {
            settings = objectMapper.readValue(Files.newBufferedReader(Path.of("settings.json")), Settings.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e + " Проблема с файлом settings.json. " +
                    "Проверьте его наличие и корректность");
        }
        return settings;
    }
}
