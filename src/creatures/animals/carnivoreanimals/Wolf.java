package creatures.animals.carnivoreanimals;

public class Wolf extends CarnivoreAnimal {
    public Wolf(int x, int y) {
        super(x, y);
    }

    {
        name = "Волк";
        weight = 50;
        maxCapacityInCell = 30;
        energy = 3;
        hanger = 8;
    }
}
