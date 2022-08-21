package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(30)
@EatingChanceNumber(2)
public class Fox extends CarnivoreAnimal{
    public Fox(int x, int y) {
        super(x, y);
    }

    public Fox (Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Лиса";
        weight = 8;
        maxHunger = 2;
        maxEnergy = 2;
        currentEnergy = new AtomicInteger(maxEnergy);;
        currentHanger = maxHunger;
    }
}
