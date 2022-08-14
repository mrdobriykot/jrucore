package creatures.animals.herbivoreanimals;

import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(20)
public class Deer extends HerbivoreAnimal{

    public Deer(int x, int y) {
        super(x, y);
    }

    public Deer(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Олень";
        weight = 300;
        energy = 4;
        hanger = 50;
    }
}
