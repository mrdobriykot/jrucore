package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(1000)
public class Caterpiller extends HerbivoreAnimal{

    public Caterpiller(int x, int y) {
        super(x, y);
    }

    {
        name = "Гусеница";
        weight = 0.01;
        energy = 0;
        hanger = 0;
    }
}
