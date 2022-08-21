package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(140)
@EatingChanceNumber(9)
public class Goat extends HerbivoreAnimal{
    public Goat(int x, int y) {
        super(x, y);
    }

    public Goat(Coordinates position) {
        super(position);
    }

    {
        name = "Коза";
        weight = 60;
        maxHunger = 10;
        maxEnergy = 3;
        currentEnergy = new AtomicInteger(maxEnergy);;
        currentHanger = maxHunger;
    }
}
