package creatures.animals.herbivoreanimals;


import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(150)
public class Rabbit extends HerbivoreAnimal{
    public Rabbit(int x, int y) {
        super(x, y);
    }

    public Rabbit(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name ="Кролик";
        weight = 2;
        energy = 2;
        hanger = 0.45;
    }
}
