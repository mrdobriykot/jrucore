package creatures.animals;

import creatures.Creature;
import interfaces.Breed;
import interfaces.*;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Animal extends Creature implements Move, Eat, Breed {
    protected int starve;
    protected List<Cell> accessibleCell = new ArrayList<>();

    public Animal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }
}
