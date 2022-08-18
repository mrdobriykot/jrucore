package creatures.animals.carnivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(20)
public class Eagle extends CarnivoreAnimal{

    public Eagle(int x, int y) {
        super(x, y);
    }

    {
        name = "Орел";
        weight = 6;
        energy = 3;
        hanger = 1;
    }
}
