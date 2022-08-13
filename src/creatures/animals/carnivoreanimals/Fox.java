package creatures.animals.carnivoreanimals;

public class Fox extends CarnivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Fox(int[][] position) {
        super(position);
    }

    public Fox(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 8;
        this.maxCapacityInCell = 30;
        this.energy = 2;
        this.hunger = 2;
    }
}
