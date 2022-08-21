package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(200)
@EatingChanceNumber(13)
public class Duck extends HerbivoreAnimal{

    public Duck(int x, int y) {
        super(x, y);
    }

    public Duck(Coordinates position) {
        super(position);
    }

    {
        name = "Утка";
        weight = 1;
        maxHunger = 0.15;
        maxEnergy = 4;
        currentEnergy = new AtomicInteger(maxEnergy);;
        currentHanger = maxHunger;
    }
}
