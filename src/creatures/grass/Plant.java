package creatures.grass;


import creatures.Creature;
import island.Coordinates;

public class Plant extends Creature {
    int weight;
    int maxCapacitySell;

    public Plant(Coordinates position) {
        super(position);
    }

    public Plant(int x, int y) {
        super(x,y);
    }

    {
        this.weight = 1;
        this.maxCapacitySell = 200;
    }
}
