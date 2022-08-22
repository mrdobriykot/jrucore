package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(20)
@EatingChanceNumber(6)
public class Deer extends HerbivoreAnimal{

    {
        setName("Олень");
    }



    public Deer(int x, int y) {
        super(x, y);
        init();
    }

    public Deer(Coordinates position) {
        super(position);
        init();
    }
}
