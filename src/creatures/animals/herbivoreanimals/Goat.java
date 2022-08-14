package creatures.animals.herbivoreanimals;

import lombok.Generated;

public class Goat extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    @Generated
    public Goat(int[][] position) {
        super(position);
    }

    public Goat(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 60;
        this.maxCapacityInCell = 10;
        this.energy = 3;
        this.hunger = 10;

    }
}
