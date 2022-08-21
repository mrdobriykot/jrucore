package island;


import creatures.animals.Animal;
import helper.Settings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {

    public static final Island instance = new Island();

    Cell[][] field;
    private int xSize = Settings.XSize;
    private int ySize = Settings.YSize;;

    private Island() {
        field = new Cell[xSize][ySize];
        initialiseField();
    }
    public Island createNewStandardField() {
        return instance;
    }

    public void addCreature(Animal animal) {
        Cell cell = getCell(animal.getPosition());
        cell.addAnimalInCell(animal);
    }
    public Cell getCell(int x, int y) {
        return field[x][y];
    }

    public Cell getCell(Coordinates coordinates) {
        return field[coordinates.getX()][coordinates.getY()];
    }
    private void initialiseField() {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                field[i][j] = new Cell(i, j);
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
