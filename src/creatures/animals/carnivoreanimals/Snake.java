package creatures.animals.carnivoreanimals;

public class Snake extends CarnivoreAnimal{
    public Snake(int x, int y) {
        super(x, y);
    }

    {
        name = "Змея";
        weight = 15;
        maxCapacityInCell = 30;
        energy = 1;
        hanger = 3;
    }
}
