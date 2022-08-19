package island;

import creatures.Creature;
import lombok.Getter;

@Getter
public class Island {

    public static final Island instance = new Island();

    Cell[][] field;
    private int xSize = 100;
    private int ySize = 20;

    private Island() {
        field = new Cell[xSize][ySize];
        initialiseField();
    }
    public Island createNewStandardField() {
        return instance;
    }

    public void addCreature(Creature creature) {
        Cell cell = getCell(creature.getPosition());
        cell.addCreatureInCell(creature);
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
}
