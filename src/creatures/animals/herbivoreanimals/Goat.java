package creatures.animals.herbivoreanimals;

import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(140)
public class Goat extends HerbivoreAnimal{
    public Goat(int x, int y) {
        super(x, y);
    }

    public Goat(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Коза";
        weight = 60;
        energy = 3;
        hanger = 10;

    }
}
