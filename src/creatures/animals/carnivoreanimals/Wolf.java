package creatures.animals.carnivoreanimals;

import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(30)
public class Wolf extends CarnivoreAnimal {
    public Wolf(int x, int y) {
        super(x, y);
    }

    public Wolf (Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Волк";
        weight = 50;
        energy = 3;
        hanger = 8;
    }
}
