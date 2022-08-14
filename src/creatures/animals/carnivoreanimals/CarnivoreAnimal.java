package creatures.animals.carnivoreanimals;

import creatures.animals.Animal;
import field.Coordinates;

public abstract class CarnivoreAnimal extends Animal {

    public CarnivoreAnimal(Coordinates position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }
}
