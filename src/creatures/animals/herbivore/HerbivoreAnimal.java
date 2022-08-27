package creatures.animals.herbivore;

import creatures.animals.Animal;
import helper.Randomizer;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;

public class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }

    @Override
    public Cell choosingDirectionForEat() {
        return getAccessibleCell().stream().max(Comparator.comparing(Cell::getHerbivoreQuantity))
                .orElse(accessibleCell.get(Randomizer.random(0, accessibleCell.size())));
    }

    @Override
    public void eat() {
    }

}
