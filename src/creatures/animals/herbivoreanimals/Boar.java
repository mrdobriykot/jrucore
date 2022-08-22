package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacityInCell(50)
@EatingChanceNumber(11)
public class Boar extends HerbivoreAnimal{

    {
        setName("Кабан");
    }


    public Boar(int x, int y) {
        super(x, y);
        init();
    }

    public Boar(Coordinates position) {
        super(position);
        init();
    }
}
