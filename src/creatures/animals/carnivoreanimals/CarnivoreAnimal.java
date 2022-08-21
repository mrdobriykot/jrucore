package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import creatures.Creature;
import creatures.animals.Animal;
import helper.EatingChance;
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
        this.currentEnergy--;
    }

    @Override
    public void eat() {
        Animal victim = chooseVictim();
        this.tryToEat(victim);
        this.currentEnergy--;
    }
}