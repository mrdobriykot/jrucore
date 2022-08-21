package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(20)
@EatingChanceNumber(4)
public class Eagle extends CarnivoreAnimal{

    public Eagle(int x, int y) {
        super(x, y);
    }

    public Eagle (Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Орел";
        weight = 6;
        maxEnergy = 3;
        maxHunger = 1;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
