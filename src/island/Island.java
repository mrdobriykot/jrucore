package island;


import creatures.animals.Animal;
import helper.Settings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {
    private static Island instance;

    static {
        instance = new Island();
    }


    public static Island getInstance() {
        return instance;
    }


    private Settings settings = Settings.initialize();

    public Settings getSettings() {
        return settings;
    }


    private int xSize = settings.XSize;
    private int ySize = settings.YSize;
    Cell[][] island = new Cell[xSize][ySize];

    private Island() {
        initialiseField();
    }

    public void addCreature(Animal animal) {
        Cell cell = getCell(animal.getPosition());
        cell.addAnimalInCell(animal);
    }
    public Cell getCell(int x, int y) {
        return island[x][y];
    }

    public Cell getCell(Coordinates coordinates) {
        return island[coordinates.getX()][coordinates.getY()];
    }

    private void initialiseField() {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                island[i][j] = new Cell(i, j);
            }
        }
    }

    public void getIslandInfo() {
        for (int i = 0; i < getXSize(); i++) {
            for (int j = 0; j < getYSize(); j++) {
                System.out.println(getCell(i, j));
            }
        }
    }
}
