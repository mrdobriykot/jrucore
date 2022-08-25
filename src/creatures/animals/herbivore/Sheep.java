package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(140)
public class Sheep extends HerbivoreAnimal{

    public Sheep(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
