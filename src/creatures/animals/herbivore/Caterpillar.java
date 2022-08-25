package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(1000)
public class Caterpillar extends HerbivoreAnimal{

    public Caterpillar(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
