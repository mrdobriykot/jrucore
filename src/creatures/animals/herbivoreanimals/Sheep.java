package creatures.animals.herbivoreanimals;


import annotation.MaxCapacityInCell;

@MaxCapacityInCell(140)
public class Sheep extends HerbivoreAnimal{

    public Sheep(int x, int y) {
        super(x, y);
    }

    {
        name = "Овца";
        weight = 70;
        energy = 3;
        hanger = 15;
    }
}
