package creatures.animals.herbivoreanimals;

import annotation.MaxCapacityInCell;

@MaxCapacityInCell(20)
public class Boar extends HerbivoreAnimal{
    public Boar(int x, int y) {
        super(x, y);
    }

    {
        name = "Кабан";
        weight = 400;
        energy = 60;
        hanger = 50;
    }
}
