package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(10)
@EatingChanceNumber(12)
public class Buffalo extends HerbivoreAnimal{

    public Buffalo(int x, int y) {
        super(x, y);
    }

    public Buffalo(Coordinates position) {
        super(position);
    }

    {
        name = "Буйвол";
        weight = 700;
        maxEnergy = 3;
        maxHunger = 100;
        currentEnergy = new AtomicInteger(maxEnergy);;
        currentHanger = maxHunger;
    }
}
