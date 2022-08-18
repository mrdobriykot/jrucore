package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(20)
public class Deer extends HerbivoreAnimal{

    public Deer(int x, int y) {
        super(x, y);
    }

    public Deer(Coordinates position) {
        super(position);
    }

    {
        name = "Олень";
        weight = 300;
        energy = 4;
        hanger = 50;
    }
}
