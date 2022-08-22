package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(150)
@EatingChanceNumber(7)
public class Rabbit extends HerbivoreAnimal{


    {
        setName("Кролик");
    }


    public Rabbit(int x, int y) {
        super(x, y);
        init();
    }

    public Rabbit(Coordinates position) {
        super(position);
        init();
    }

}
