package creatures.animals.herbivoreanimals;


public class Rabbit extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    double hunger;


    public Rabbit(int[][] position) {
        super(position);
    }

    public Rabbit(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 2;
        this.maxCapacityInCell = 150;
        this.energy = 2;
        this.hunger = 0.45;
    }
}
