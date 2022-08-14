package creatures.animals.herbivoreanimals;


import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(10)
public class Buffalo extends HerbivoreAnimal{

    public Buffalo(int x, int y) {
        super(x, y);
    }

    public Buffalo(Coordinates position) {
        super(position);
    }

    {
        name = "Буйвол";
        weight = 700;
        energy = 3;
        hanger = 50;
    }
}
