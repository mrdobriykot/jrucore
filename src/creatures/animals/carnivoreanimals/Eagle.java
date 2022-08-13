package creatures.animals.carnivoreanimals;

public class Eagle extends CarnivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Eagle(int[][] position) {
        super(position);
    }

    public Eagle(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 6;
        this.maxCapacityInCell = 20;
        this.energy = 3;
        this.hunger = 1;
    }
}
