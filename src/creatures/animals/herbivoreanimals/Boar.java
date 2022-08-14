package creatures.animals.herbivoreanimals;

public class Boar extends HerbivoreAnimal{
    public Boar(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 400;
        this.maxCapacityInCell = 20;
        this.energy = 60;
        this.hanger = 50;
    }
}
