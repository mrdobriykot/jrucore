package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(30)
@EatingChanceNumber(1)
public class Snake extends CarnivoreAnimal{
    public Snake(int x, int y) {
        super(x, y);
    }

    public Snake (Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Змея";
        weight = 15;
        maxEnergy = 1;
        currentEnergy = maxEnergy;
        maxHunger = 3;
        currentHanger = maxEnergy;
    }
}
