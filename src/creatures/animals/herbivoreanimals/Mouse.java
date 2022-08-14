package creatures.animals.herbivoreanimals;



public class Mouse extends HerbivoreAnimal{

    double weight;
    int maxCapacityInCell;
    int energy;
    double hunger;


    public Mouse(int[][] position) {
        super(position);
    }

    public Mouse(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 0.05;
        this.maxCapacityInCell = 500;
        this.energy = 1;
        this.hunger = 0.01;
    }
}
