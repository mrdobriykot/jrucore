package creatures.animals.herbivoreanimals;



public class Mouse extends HerbivoreAnimal{
    public Mouse(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 0.05;
        this.maxCapacityInCell = 500;
        this.energy = 1;
        this.hanger = 0.01;
    }
}
