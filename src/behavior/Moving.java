package behavior;

import island.Cell;
import island.Island;

public interface Moving {
    default Cell chooseDirection() {
        System.out.println("Животное выбирает направление для движения");
        return Island.instance.getCell(0,0);
    }

    void moveTo (Cell newCell);
}
