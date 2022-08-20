package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

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
        energy = 3;
        hanger = 10;
    }
}
