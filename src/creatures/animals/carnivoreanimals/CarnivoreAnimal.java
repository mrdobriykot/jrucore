package creatures.animals.carnivoreanimals;

import creatures.animals.Animal;

public abstract class CarnivoreAnimal extends Animal {

    public CarnivoreAnimal(int[][] position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }
}
