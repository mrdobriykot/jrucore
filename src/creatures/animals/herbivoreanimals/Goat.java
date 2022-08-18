package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(140)
public class Goat extends HerbivoreAnimal{
    public Goat(int x, int y) {
        super(x, y);
    }

    {
        name = "Коза";
        weight = 60;
        energy = 3;
        hanger = 10;
    }
}
