package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(20)
public class Deer extends HerbivoreAnimal{

    public Deer(int x, int y) {
        super(x, y);
    }

    {
        name = "Олень";
        weight = 300;
        energy = 4;
        hanger = 50;
    }
}
