package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(200)
public class Duck extends HerbivoreAnimal{

    public Duck(int x, int y) {
        super(x, y);
    }

    public Duck(Coordinates position) {
        super(position);
    }

    {
        name = "Утка";
        weight = 1;
        energy = 4;
        hanger = 0.15;
    }
}
