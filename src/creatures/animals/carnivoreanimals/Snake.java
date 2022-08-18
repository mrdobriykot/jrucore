package creatures.animals.carnivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(30)
public class Snake extends CarnivoreAnimal{
    public Snake(int x, int y) {
        super(x, y);
    }

    {
        name = "Змея";
        weight = 15;
        energy = 1;
        hanger = 3;
    }
}
