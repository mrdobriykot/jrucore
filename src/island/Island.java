package island;

import lombok.Getter;
import lombok.Setter;
import settings.Settings;

@Getter
@Setter
public class Island {

    private static Island instance;
    private Settings settings = Settings.initialize();

    static  {
        instance = new Island();
    }

    public static Island getInstance() {
        return instance;
    }
}
