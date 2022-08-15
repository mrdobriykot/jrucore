package creatures.animals.herbivoreanimals;


import annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(140)
public class Sheep extends HerbivoreAnimal{

    public Sheep(int x, int y) {
        super(x, y);
    }

    public Sheep(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Овца";
        weight = 70;
        energy = 3;
        hanger = 15;
    }
}
