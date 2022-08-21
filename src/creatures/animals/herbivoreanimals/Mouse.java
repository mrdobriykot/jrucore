package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

@MaxCapacityInCell(500)
@EatingChanceNumber(8)
public class Mouse extends HerbivoreAnimal{
    public Mouse(int x, int y) {
        super(x, y);
    }

    public Mouse(Coordinates position) {
        super(position);
    }

    {
        name = "Мышь";
        weight = 0.05;
        maxEnergy = 1;
        maxHunger = 0.01;
        currentEnergy = maxEnergy;
        currentHanger = maxHunger;
    }
}
