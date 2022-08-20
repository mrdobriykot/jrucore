package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

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
        energy = 3;
        hanger = 1;
    }
}
