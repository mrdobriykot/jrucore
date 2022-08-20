package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(20)
@EatingChanceNumber(5)
public class Horse extends HerbivoreAnimal{

    public Horse(int x, int y) {
        super(x, y);
    }

    public Horse(Coordinates position) {
        super(position);
    }

    {
        name = "Лошадь";
        weight = 400;
        energy = 4;
        hanger = 60;
    }
}
