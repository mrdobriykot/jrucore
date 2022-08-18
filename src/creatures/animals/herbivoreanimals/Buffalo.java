package creatures.animals.herbivoreanimals;


import annotation.MaxCapacityInCell;

@MaxCapacityInCell(10)
class Buffalo extends HerbivoreAnimal{

    public Buffalo(int x, int y) {
        super(x, y);
    }

    {
        name = "Буйвол";
        weight = 700;
        energy = 3;
        hanger = 50;
    }
}
