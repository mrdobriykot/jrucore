package creatures.animals.herbivoreanimals;

public class Duck extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    double energy;
    int hunger;

    public Duck(int[][] position) {
        super(position);
    }

    public Duck(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 1;
        this.maxCapacityInCell = 200;
        this.hunger = 4;
        this.energy = 0.15;
    }
}
