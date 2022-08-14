package creatures.animals.carnivoreanimals;

import field.Coordinates;

public class Bear extends CarnivoreAnimal{

    public Bear(Coordinates position) {
        super(position);
    }

    public Bear(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 500;
        this.maxCapacityInCell = 5;
        this.energy = 2;
        this.hanger = 80;
    }
}
