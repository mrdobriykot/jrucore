package creatures.animals.carnivore;

import creatures.animals.Animal;
import island.Cell;
import island.Coordinates;
import island.Island;

public class CarnivoreAnimal extends Animal {

    public CarnivoreAnimal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }

    @Override
    public Cell choosingDirectionForEat() {
        return null;
    }

    @Override
    public void breed() {

    }

    @Override
    public void eat() {

    }
}
