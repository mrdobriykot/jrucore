package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(140)
public class Goat extends HerbivoreAnimal{

    public Goat(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
