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
    public Animal animal;


    public AnimalBehavior(Animal behavior) {
        animal = behavior;
    }
    @Override
    public void run() {
        do {
            act();
        } while (animal.getCurrentEnergy().get() != 0);
    }


    private Cell randomCell(){
        return animal.getAccessibleCells().get(ThreadLocalRandom.current().nextInt(0, 4));
    }


    public void act() {
        Cell cell = Island.instance.getCell(animal.getPosition());
        if (animal.getCurrentHanger() < animal.getMaxHunger()*0.5) {
            animal.eat();
        } else {
            animal.breed();
        }
    }
}
