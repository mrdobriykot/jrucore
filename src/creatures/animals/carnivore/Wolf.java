package creatures.animals.carnivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(30)
public class Wolf extends CarnivoreAnimal{

    public Wolf(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
