package creatures.animals.herbivoreanimals;

import creatures.animals.Animal;

public abstract class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(int[][] position) {
        super(position);
    }

    public HerbivoreAnimal(int x, int y) {
        super(x, y);
    }
}
