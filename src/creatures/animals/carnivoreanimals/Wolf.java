package creatures.animals.carnivoreanimals;

import Annotation.MaxCapacity;
import island.Coordinates;

import java.security.DrbgParameters;

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
