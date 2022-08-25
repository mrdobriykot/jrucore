package creatures.animals.carnivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(20)
public class Eagle extends CarnivoreAnimal{

    public Eagle(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
