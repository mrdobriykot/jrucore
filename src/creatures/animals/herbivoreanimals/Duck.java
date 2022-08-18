package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(200)
public class Duck extends HerbivoreAnimal{

    public Duck(int x, int y) {
        super(x, y);
    }

    {
        name = "Утка";
        weight = 1;
        energy = 4;
        hanger = 0.15;
    }
}
