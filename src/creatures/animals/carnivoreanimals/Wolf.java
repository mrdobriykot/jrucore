package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(30)
@EatingChanceNumber(0)
public class Wolf extends CarnivoreAnimal {

    {
        setName("Волк");
    }


    public Wolf(int x, int y) {
        super(x, y);
        init();
    }

    public Wolf (Coordinates coordinates) {
        super(coordinates);
        init();
    }
}
