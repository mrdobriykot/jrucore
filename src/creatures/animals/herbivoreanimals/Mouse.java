package creatures.animals.herbivoreanimals;


import Annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(500)
public class Mouse extends HerbivoreAnimal{
    public Mouse(int x, int y) {
        super(x, y);
    }

    public Mouse(Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Мышь";
        weight = 0.05;
        energy = 1;
        hanger = 0.01;
    }
}
