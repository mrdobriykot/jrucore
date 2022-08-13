package creatures.animals.carnivoreanimals;

import creatures.animals.carnivoreanimals.CarnivoreAnimal;

public class Wolf extends CarnivoreAnimal {

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Wolf(int[][] position) {
        super(position);
    }

    public Wolf(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 50;
        this.maxCapacityInCell = 30;
        this.energy = 3;
        this.hunger = 8;
    }
}
