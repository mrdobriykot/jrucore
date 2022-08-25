package creatures.animals;

import creatures.Creature;
import interfaces.Breed;
import interfaces.*;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal extends Creature implements Move, Eat, Breed {

    public Animal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }
}
