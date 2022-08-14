package creatures.animals.herbivoreanimals;

public class Horse extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Horse(int[][] position) {
        super(position);
    }

    public Horse(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 400;
        this.maxCapacityInCell = 20;
        this.hunger = 4;
        this.energy = 60;
    }
}
