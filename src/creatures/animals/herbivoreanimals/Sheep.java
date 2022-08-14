package creatures.animals.herbivoreanimals;


public class Sheep extends HerbivoreAnimal{

    int weight;
    int maxCapacityInCell;
    int energy;
    int hunger;


    public Sheep(int[][] position) {
        super(position);
    }

    public Sheep(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 70;
        this.maxCapacityInCell = 140;
        this.energy = 3;
        this.hunger = 15;
    }
}
