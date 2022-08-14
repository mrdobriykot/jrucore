package creatures.animals.herbivoreanimals;

import lombok.Generated;

public class Buffalo extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    @Generated
    public Buffalo(int[][] position) {
        super(position);
    }

    public Buffalo(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 700;
        this.maxCapacityInCell = 10;
        this.hunger = 3;
        this.energy = 100;
    }
}
