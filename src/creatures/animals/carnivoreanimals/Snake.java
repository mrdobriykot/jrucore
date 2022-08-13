package creatures.animals.carnivoreanimals;

public class Snake extends CarnivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Snake(int[][] position) {
        super(position);
    }

    public Snake(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 15;
        this.maxCapacityInCell = 30;
        this.energy = 1;
        this.hunger = 3;
    }
}
