package behaivior;

import creatures.Creature;

public interface Eating {
    default void eat(Creature creature) {
        System.out.println(String.format(" %s съел %s", this, creature));
    }
}
