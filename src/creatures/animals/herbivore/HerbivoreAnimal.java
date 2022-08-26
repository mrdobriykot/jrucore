package creatures.animals.herbivore;

import creatures.animals.Animal;
import island.Cell;
import island.Coordinates;
import island.Island;

public class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }

    @Override
    public Cell choosingDirectionForEat() {
        return null;
    }

    @Override
    public void eat() {
    }

    @Override
    public void breed() {

    }
}
