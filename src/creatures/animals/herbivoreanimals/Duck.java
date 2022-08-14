package creatures.animals.herbivoreanimals;

import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(200)
public class Duck extends HerbivoreAnimal{

    public Duck(int x, int y) {
        super(x, y);
    }

    public Duck(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Утка";
        weight = 1;
        energy = 4;
        hanger = 0.15;
    }
}
