package creatures.animals.herbivoreanimals;


import annotation.MaxCapacityInCell;

@MaxCapacityInCell(150)
public class Rabbit extends HerbivoreAnimal{
    public Rabbit(int x, int y) {
        super(x, y);
    }

    {
        name = "Кролик";
        weight = 2;
        energy = 2;
        hanger = 0.45;
    }
}
