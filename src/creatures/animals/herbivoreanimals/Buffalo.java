package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(10)
@EatingChanceNumber(12)
public class Buffalo extends HerbivoreAnimal{

    {
        setName("Буйвол");
    }

    public Buffalo(int x, int y) {
        super(x, y);
        init();
    }

    public Buffalo(Coordinates position) {
        super(position);
        init();
    }
}
