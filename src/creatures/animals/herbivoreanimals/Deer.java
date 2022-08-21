package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(20)
@EatingChanceNumber(6)
public class Deer extends HerbivoreAnimal{

    public Deer(int x, int y) {
        super(x, y);
    }

    public Deer(Coordinates position) {
        super(position);
    }

    {
        name = "Олень";
        weight = 300;
        maxHunger = 4;
        maxEnergy = 50;
        currentEnergy = maxEnergy;
        currentHanger = maxHunger;
    }
}
