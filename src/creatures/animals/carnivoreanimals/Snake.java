package creatures.animals.carnivoreanimals;

import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(30)
public class Snake extends CarnivoreAnimal{
    public Snake(int x, int y) {
        super(x, y);
    }

    public Snake(Coordinates position) {
        super(position);
    }

    {
        name = "Змея";
        weight = 15;
        energy = 1;
        hanger = 3;
    }
}
