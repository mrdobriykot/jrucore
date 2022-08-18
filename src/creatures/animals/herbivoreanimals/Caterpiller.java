package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(1000)
public class Caterpiller extends HerbivoreAnimal{

    public Caterpiller(int x, int y) {
        super(x, y);
    }

    public Caterpiller(Coordinates position) {
        super(position);
    }

    {
        name = "Гусеница";
        weight = 0.01;
        energy = 0;
        hanger = 0;
    }
}
