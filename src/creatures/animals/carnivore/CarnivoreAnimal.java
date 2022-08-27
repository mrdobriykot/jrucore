package creatures.animals.carnivore;

import creatures.animals.Animal;
import helper.Randomizer;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;
import java.util.List;

public class CarnivoreAnimal extends Animal {

    public CarnivoreAnimal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }
    public CarnivoreAnimal(int x, int y, Island island) {
        super(x, y, island);
    }

    @Override
    public Cell choosingDirectionForEat() {
        return getAccessibleCell().stream().max(Comparator.comparing(Cell::getHerbivoreQuantity))
                .orElse(accessibleCell.get(Randomizer.random(0,accessibleCell.size())));
    }

    @Override
    public void moveTo(Cell newCell) {
        super.moveTo(newCell);
        reduceEnergy();
    }

    @Override
    public void eat() {
        List<Animal> accessibleAnimals = cell.getFauna().stream()
                .filter(e -> this.getLuck().get(e.getName()) > 0)
                .toList();
        if (!accessibleAnimals.isEmpty()) {
            Animal victim = chooseVictim(accessibleAnimals);
            tryToEat(victim);
        } else {
            initializeAccessibleCell();
            moveTo(choosingDirectionForEat());
        }
        reduceEnergy();
    }
}
