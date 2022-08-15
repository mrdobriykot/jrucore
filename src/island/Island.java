package island;

import creatures.Creature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {

    public static final Island instance = new Island();

    Cell[][] island;
    private int xSize = 100;
    private int ySize = 20;

    private Island() {
        island = new Cell[xSize][ySize];
        initialiseIsland();
    }
    public static Island createNewStandardField() {
        return instance;
    }

    public void addCreature(Creature creature) {
        Cell cell = getCell(creature.getPosition());
        cell.addCreatureInCell(creature);
    }

    public Cell getCell(Coordinates position) {
        return island[position.getX()][position.getY()];
    }

    public Cell getCell(int x, int y) {
        return island[x][y];
    }

    private void initialiseIsland() {
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
