package creatures.animals.carnivore;

import annotation.MaxCapacity;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MaxCapacity(5)
public class Bear extends CarnivoreAnimal{

    public Bear(Coordinates coordinates, Island island) {
        super(coordinates, island);
        init();
    }
}
