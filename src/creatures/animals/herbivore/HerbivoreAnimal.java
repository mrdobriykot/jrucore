package creatures.animals.herbivore;

import creatures.animals.Animal;
import island.Coordinates;
import island.Island;

public class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }

    @Override
    public void leaveCell() {

    }

    @Override
    public void eat() {
        super.eat();
    }
}
