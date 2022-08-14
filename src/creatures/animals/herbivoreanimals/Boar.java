package creatures.animals.herbivoreanimals;

public class Boar extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;

    public Boar(int[][] position) {
        super(position);
    }

    public Boar(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 400;
        this.maxCapacityInCell = 20;
        this.hunger = 4;
        this.energy = 60;
    }
}
