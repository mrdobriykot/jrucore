package creatures.animals.carnivoreanimals;

import annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(30)
public class Wolf extends CarnivoreAnimal {
    public Wolf(int x, int y) {
        super(x, y);
    }

    public Wolf(Coordinates position) {
        super(position);
    }

    {
        name = "Волк";
        weight = 50;
        energy = 3;
        hanger = 8;
    }
}
