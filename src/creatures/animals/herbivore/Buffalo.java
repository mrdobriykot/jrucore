package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(10)
public class Buffalo extends HerbivoreAnimal{

    public Buffalo(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
