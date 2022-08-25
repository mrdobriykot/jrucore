package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(500)
public class Mouse extends HerbivoreAnimal{

    public Mouse(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
