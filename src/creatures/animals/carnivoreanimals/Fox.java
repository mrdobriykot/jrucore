package creatures.animals.carnivoreanimals;

import field.Coordinates;

public class Fox extends CarnivoreAnimal{

    public Fox(Coordinates position) {
        super(position);
    }

    public Fox(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 8;
        this.maxCapacityInCell = 30;
        this.energy = 2;
        this.hanger = 2;
    }
}
