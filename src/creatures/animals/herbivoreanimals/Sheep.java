package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(140)
@EatingChanceNumber(10)
public class Sheep extends HerbivoreAnimal{

    public Sheep(int x, int y) {
        super(x, y);
    }

    public Sheep(Coordinates position) {
        super(position);
    }

    {
        name = "Овца";
        weight = 70;
        energy = 3;
        hanger = 15;
    }
}
