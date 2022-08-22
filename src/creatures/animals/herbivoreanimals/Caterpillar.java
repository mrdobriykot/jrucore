package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(1000)
@EatingChanceNumber(14)
public class Caterpillar extends HerbivoreAnimal{

    {
        setName("Гусенница");
    }

    public Caterpillar(int x, int y) {
        super(x, y);
        init();
    }

    public Caterpillar(Coordinates position) {
        super(position);
        init();
    }
}
