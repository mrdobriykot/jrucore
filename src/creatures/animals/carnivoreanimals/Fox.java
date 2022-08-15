package creatures.animals.carnivoreanimals;

import annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(30)
public class Fox extends CarnivoreAnimal{
    public Fox(int x, int y) {
        super(x, y);
    }

    public Fox(Coordinates position) {
        super(position);
    }

    {
        name = "Лиса";
        weight = 8;
        energy = 2;
        hanger = 2;
    }
}
