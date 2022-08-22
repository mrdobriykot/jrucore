package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(20)
@EatingChanceNumber(4)
public class Eagle extends CarnivoreAnimal{

    {
        setName("Орел");
    }

    public Eagle(int x, int y) {
        super(x, y);
        init();
    }

    public Eagle (Coordinates coordinates) {
        super(coordinates);
        init();
    }

}
