package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(20)
public class Deer extends HerbivoreAnimal{

    public Deer(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
