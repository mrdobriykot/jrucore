package creatures.animals.herbivoreanimals;

import creatures.animals.Animal;
import island.Coordinates;

public abstract class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates position) {
        super(position);
    }

    public HerbivoreAnimal(int x, int y) {
        super(x, y);
    }
}
