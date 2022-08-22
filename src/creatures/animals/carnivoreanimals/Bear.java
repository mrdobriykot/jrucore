package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@MaxCapacityInCell(5)
@EatingChanceNumber(3)
public class Bear extends CarnivoreAnimal{

    {
        setName("Медведь");
    }

    public Bear(int x, int y) {
        super(x, y);
        init();
    }

    public Bear (Coordinates coordinates) {
        super(coordinates);
        init();
    }

}
