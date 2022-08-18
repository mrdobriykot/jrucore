package creatures.animals.herbivoreanimals;


import annotation.MaxCapacityInCell;

@MaxCapacityInCell(500)
public class Mouse extends HerbivoreAnimal{
    public Mouse(int x, int y) {
        super(x, y);
    }

    {
        name = "Мышь";
        weight = 0.05;
        energy = 1;
        hanger = 0.01;
    }
}
