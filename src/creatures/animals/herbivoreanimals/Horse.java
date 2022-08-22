package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(20)
@EatingChanceNumber(5)
public class Horse extends HerbivoreAnimal{

    {
        setName("Лошадь");
    }

    public Horse(int x, int y) {
        super(x, y);
        init();
    }

    public Horse(Coordinates position) {
        super(position);
        init();
    }
}
