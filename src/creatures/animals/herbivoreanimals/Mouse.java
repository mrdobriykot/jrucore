package creatures.animals.herbivoreanimals;


import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(500)
@EatingChanceNumber(8)
public class Mouse extends HerbivoreAnimal{

    {
        setName("Мышь");
    }


    public Mouse(int x, int y) {
        super(x, y);
        init();
    }

    public Mouse(Coordinates position) {
        super(position);
        init();
    }
}
