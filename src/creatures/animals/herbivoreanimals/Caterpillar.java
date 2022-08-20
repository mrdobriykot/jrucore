package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(1000)
@EatingChanceNumber(14)
public class Caterpillar extends HerbivoreAnimal{

    public Caterpillar(int x, int y) {
        super(x, y);
    }

    public Caterpillar(Coordinates position) {
        super(position);
    }

    {
        name = "Гусеница";
        weight = 0.01;
        energy = 0;
        hanger = 0;
    }
}
