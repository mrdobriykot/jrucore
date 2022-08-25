package creatures.animals.herbivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;

@MaxCapacity(200)
public class Duck extends HerbivoreAnimal{

    public Duck(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
