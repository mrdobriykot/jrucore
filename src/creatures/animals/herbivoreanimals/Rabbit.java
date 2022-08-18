package creatures.animals.herbivoreanimals;


import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(150)
public class Rabbit extends HerbivoreAnimal{
    public Rabbit(int x, int y) {
        super(x, y);
    }

    public Rabbit(Coordinates position) {
        super(position);
    }

    {
        name = "Кролик";
        weight = 2;
        energy = 2;
        hanger = 0.45;
    }
}
