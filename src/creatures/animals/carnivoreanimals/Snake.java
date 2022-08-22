package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(30)
@EatingChanceNumber(1)
public class Snake extends CarnivoreAnimal{

    {
        setName("Удав");
    }

    public Snake(int x, int y) {
        super(x, y);
        init();
    }

    public Snake (Coordinates coordinates) {
        super(coordinates);
        init();
    }

}
