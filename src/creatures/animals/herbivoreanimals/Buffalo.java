package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

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
        currentEnergy = maxEnergy;
        currentHanger = maxHunger;
    }
}
