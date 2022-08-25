package creatures.animals.carnivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(30)
public class Snake extends CarnivoreAnimal{

    public Snake(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
