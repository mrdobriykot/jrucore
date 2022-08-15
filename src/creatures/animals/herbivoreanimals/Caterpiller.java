package creatures.animals.herbivoreanimals;

import annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(1000)
public class Caterpiller extends HerbivoreAnimal{

    public Caterpiller(int x, int y) {
        super(x, y);
    }

    public Caterpiller(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Гусеница";
        weight = 0.01;
        energy = 0;
        hanger = 0;
    }
}
