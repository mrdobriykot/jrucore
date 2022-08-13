package creatures.animals.carnivoreanimals;

public class Bear extends CarnivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Bear(int[][] position) {
        super(position);
    }

    public Bear(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 500;
        this.maxCapacityInCell = 5;
        this.energy = 2;
        this.hunger = 80;
    }
}
