package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(150)
public class Rabbit extends HerbivoreAnimal{

    public Rabbit(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
