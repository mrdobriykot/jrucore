package creatures.grass;


import creatures.Creature;

public class Plant extends Creature {
    int weight;
    int maxCapacitySell;

    public Plant(int[][] position) {
        super(position);
    }

    public Plant(int x, int y) {
        super(new int[][]{{x,y}});
    }

    {
        this.weight = 1;
        this.maxCapacitySell = 200;
    }
}
