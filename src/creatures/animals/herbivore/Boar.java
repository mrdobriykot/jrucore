package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(50)
public class Boar extends HerbivoreAnimal{

    public Boar(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
