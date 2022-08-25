package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(20)
public class Horse extends HerbivoreAnimal{

    public Horse(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
