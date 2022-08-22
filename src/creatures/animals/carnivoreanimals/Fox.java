package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(30)
@EatingChanceNumber(2)
public class Fox extends CarnivoreAnimal{

    {
        setName("Лиса");
    }

    public Fox(int x, int y) {
        super(x, y);
        init();
    }

    public Fox (Coordinates coordinates) {
        super(coordinates);
        init();
    }

}
