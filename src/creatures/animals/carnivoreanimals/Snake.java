package creatures.animals.carnivoreanimals;

import field.Coordinates;

public class Snake extends CarnivoreAnimal{

    public Snake(Coordinates position) {
        super(position);
    }

    public Snake(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 15;
        this.maxCapacityInCell = 30;
        this.energy = 1;
        this.hanger = 3;
    }
}
