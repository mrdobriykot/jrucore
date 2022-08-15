package creatures.animals.herbivoreanimals;

import annotation.MaxCapacity;
import island.Coordinates;

@MaxCapacity(20)
public class Boar extends HerbivoreAnimal{
    public Boar(int x, int y) {
        super(x, y);
    }

    public Boar(Coordinates position) {
        super(position);
    }

    {
        name = "Кабан";
        weight = 400;
        energy = 60;
        hanger = 50;
    }
}
