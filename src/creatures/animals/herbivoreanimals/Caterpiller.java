package creatures.animals.herbivoreanimals;

public class Caterpiller extends HerbivoreAnimal{

    double weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Caterpiller(int[][] position) {
        super(position);
    }

    public Caterpiller(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 0.01;
        this.maxCapacityInCell = 1000;
        this.hunger = 0;
        this.energy = 0;
    }
}
