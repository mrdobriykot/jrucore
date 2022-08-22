package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(140)
@EatingChanceNumber(10)
public class Sheep extends HerbivoreAnimal{

    {
        setName("Овца");
    }

    public Sheep(int x, int y) {
        super(x, y);
        init();
    }

    public Sheep(Coordinates position) {
        super(position);
        init();
    }
}
