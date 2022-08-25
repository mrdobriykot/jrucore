package creatures.animals.carnivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(30)
public class Fox extends CarnivoreAnimal{

    public Fox(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
