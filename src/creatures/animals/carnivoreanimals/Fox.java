package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

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
        energy = 2;
        hanger = 2;
    }
}
