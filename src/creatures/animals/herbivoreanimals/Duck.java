package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(200)
@EatingChanceNumber(13)
public class Duck extends HerbivoreAnimal{

    {
        setName("Утка");
    }


    public Duck(int x, int y) {
        super(x, y);
        init();
    }

    public Duck(Coordinates position) {
        super(position);
        init();
    }
}
