package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(20)
@EatingChanceNumber(5)
public class Horse extends HerbivoreAnimal{

    public Horse(int x, int y) {
        super(x, y);
    }

    public Horse(Coordinates position) {
        super(position);
    }

    {
        name = "Лошадь";
        weight = 400;
        maxEnergy = 4;
        maxHunger = 60;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
