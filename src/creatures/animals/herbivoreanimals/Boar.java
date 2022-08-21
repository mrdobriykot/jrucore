package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(50)
@EatingChanceNumber(11)
public class Boar extends HerbivoreAnimal{
    public Boar(int x, int y) {
        super(x, y);
    }

    public Boar(Coordinates position) {
        super(position);
    }

    {
        name = "Кабан";
        weight = 400;
        maxEnergy = 2;
        maxHunger = 50;
        currentEnergy = maxEnergy;
        currentHanger = maxHunger;
    }
}
