package creatures.animals;

import creatures.Creature;

public abstract class Animal extends Creature {

    protected Animal(int[][] position) {
        super(position);
    }

    public Animal(int x, int y) {
        super(new int[][]{{x, y}});
    }
}
