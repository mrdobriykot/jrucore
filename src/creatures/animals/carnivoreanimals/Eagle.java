package creatures.animals.carnivoreanimals;

import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(20)
public class Eagle extends CarnivoreAnimal{

    public Eagle(int x, int y) {
        super(x, y);
    }

    public Eagle(Coordinates position) {
        super(position);
    }

    {
        name = "Орел";
        weight = 6;
        energy = 3;
        hanger = 1;
    }
}
