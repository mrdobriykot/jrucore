package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import creatures.Creature;
import creatures.animals.Animal;
import helper.EatingChance;
import helper.Randomizer;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public abstract class CarnivoreAnimal extends Animal {

    public CarnivoreAnimal(Coordinates position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public void moveTo(Cell newCell) {
        super.moveTo(newCell);
        reduceEnergy();
    }

    @Override
    public void eat() {
        Cell cell = Island.instance.getCell(getPosition());
        if (cell.getHerbivoreQty() > 0) {
            Animal victim = chooseVictim();
            tryToEat(victim);
        } else {
            moveTo(choosingDirectionForEat());
        }
        reduceEnergy();
    }
    public Cell choosingDirectionForEat() {
        return getAccessibleCells().stream()
                .max(Comparator.comparing(Cell::getHerbivoreQty))
                .orElse(accessibleCells.get(Randomizer.randomize(0, accessibleCells.size())));
    }
}