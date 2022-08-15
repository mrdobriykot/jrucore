package creatures.animals.herbivoreanimals;

import annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(20)
public class Horse extends HerbivoreAnimal{

    public Horse(int x, int y) {
        super(x, y);
    }

    public Horse(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Лошадь";
        weight = 400;
        energy = 4;
        hanger = 60;
    }
}
