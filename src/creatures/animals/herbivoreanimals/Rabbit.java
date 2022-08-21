package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(150)
@EatingChanceNumber(7)
public class Rabbit extends HerbivoreAnimal{
    public Rabbit(int x, int y) {
        super(x, y);
    }

    public Rabbit(Coordinates position) {
        super(position);
    }

    {
        name = "Кролик";
        weight = 2;
        maxEnergy = 2;
        maxHunger = 0.45;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
