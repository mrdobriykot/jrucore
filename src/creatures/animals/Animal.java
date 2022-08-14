package creatures.animals;

import creatures.Creature;
import creatures.behaivior.Breeding;
import creatures.behaivior.Eating;
import creatures.behaivior.Moving;
import field.Coordinates;
import lombok.Getter;

@Getter
public abstract class Animal extends Creature implements Eating, Moving, Breeding {

    protected double weight;
    protected int maxCapacityInCell;
    protected int energy;
    protected double hanger;

    protected Animal(Coordinates position) {
        super(position);
    }

    public Animal(int x, int y) {
        super(new Coordinates(x,y));
    }
}
