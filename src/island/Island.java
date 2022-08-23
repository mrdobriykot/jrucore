package island;

import lombok.Getter;
import lombok.Setter;
import settings.Settings;

@Getter
@Setter
public class Island {

    private static Island instance;
    private Settings settings = Settings.initialize();
    private int width = settings.getWidth();
    private int height = settings.getHeight();
    Cell [][] island = new Cell[width][height];

    static  {
        instance = new Island();
    }

    private Island() {
        initIsland();
    }

    public static Island getInstance() {
        return instance;
    }

    public Cell getCell(int x, int y) {
        return island[x][y];
    }

    public void initIsland() {
        for (int x =0; x< width; x++) {
            for (int y = 0; y < height; y++) {
                island[x][y] = new Cell(x, y);
            }
        }
    }
}
