package simulation;

import creatures.animals.Animal;
import creatures.animals.carnivoreanimals.CarnivoreAnimal;
import creatures.animals.herbivoreanimals.HerbivoreAnimal;
import island.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalBehavior implements Runnable{
    Cell cell;


    public AnimalBehavior(Cell cell) {
        this.cell = cell;
    }
    @Override
    public void run() {
        cell.getFauna().stream().forEach(animal -> {
            animal.getLogList().clear();
            do {
                if (animal.getCurrentHanger() < animal.getMaxHunger() * 0.5) {
                    animal.eat();
                } else {
                    animal.breed();
                }
            } while (animal.getCurrentEnergy().get() > 0);
        });
    }
}
