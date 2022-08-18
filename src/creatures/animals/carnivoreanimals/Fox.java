package creatures.animals.carnivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(30)
public class Fox extends CarnivoreAnimal{
    public Fox(int x, int y) {
        super(x, y);
    }

    {
        name = "Лиса";
        weight = 8;
        energy = 2;
        hanger = 2;
    }
}
