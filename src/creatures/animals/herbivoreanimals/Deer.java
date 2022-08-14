package creatures.animals.herbivoreanimals;

public class Deer extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Deer(int[][] position) {
        super(position);
    }

    public Deer(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 300;
        this.maxCapacityInCell = 20;
        this.hunger = 4;
        this.energy = 50;
    }
}
