package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(140)
@EatingChanceNumber(10)
public class Sheep extends HerbivoreAnimal{

    public Sheep(int x, int y) {
        super(x, y);
    }

    public Sheep(Coordinates position) {
        super(position);
    }

    {
        name = "Овца";
        weight = 70;
        maxEnergy = 3;
        maxHunger = 15;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
