package creatures.animals.herbivore;

import creatures.animals.Animal;
import creatures.plants.Plants;
import helper.Randomizer;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;
import java.util.List;

public class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }
    public HerbivoreAnimal(int x, int y, Island island) {
        super(x, y, island);
    }

    @Override
    public Cell choosingDirectionForEat() {
        return getAccessibleCells().stream()
                .max(Comparator.comparing(Cell::getHerbivoreQuantity))
                .orElse(accessibleCells.get(Randomizer.random(0, accessibleCells.size())));
    }

    @Override
    public void eat() {
        if (cell.getPlantsQuantity() > 0) {
            List<Animal> accessibleAnimals = cell.getFauna().stream()
                    .filter(e -> this.getLuck().get(e.getName()) > 0)
                    .toList();
            if (!accessibleAnimals.isEmpty()) {
                Animal victim = chooseVictim(accessibleAnimals);
                tryToEat(victim);
            } else  if (!cell.getFlora().isEmpty()){
                Plants plant = cell.getFlora().stream().findAny().orElse(cell.getFlora().get(0));
                plant.die();
                currentHanger += Island.getInstance().getSettings().getPlantsNutritionalValue();
                if (currentHanger > maxHunger) {
                    currentHanger = maxHunger;
                }
            }
        } else {
            initializeAccessibleCell();
            moveTo(choosingDirectionForEat());
        }
        reduceEnergy();
    }
}
