package creatures.animals.herbivoreanimals;


public class Rabbit extends HerbivoreAnimal{
    public Rabbit(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 2;
        this.maxCapacityInCell = 150;
        this.energy = 2;
        this.hanger = 0.45;
    }
}
