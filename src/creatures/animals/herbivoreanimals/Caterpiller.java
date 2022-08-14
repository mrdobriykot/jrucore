package creatures.animals.herbivoreanimals;

public class Caterpiller extends HerbivoreAnimal{

    public Caterpiller(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 0.01;
        this.maxCapacityInCell = 1000;
        this.energy = 0;
        this.hanger = 0;
    }
}
