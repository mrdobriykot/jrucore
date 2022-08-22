package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(140)
@EatingChanceNumber(9)
public class Goat extends HerbivoreAnimal{

    {
        setName("Коза");
    }


    public Goat(int x, int y) {
        super(x, y);
        init();
    }

    public Goat(Coordinates position) {
        super(position);
        init();
    }
}
