package simulation;

import annotation.MaxCapacity;
import creatures.Creature;
import creatures.animals.Animal;
import helper.CoordinatesGenerator;
import helper.Randomizer;
import island.Coordinates;
import island.Island;

public class AnimalDeployer implements Runnable{
    private final Class<? extends Creature> creatureClass;
    private final Island island;

    public AnimalDeployer(Class<? extends Creature> clazz, Island island) {
        this.creatureClass = clazz;
        this.island = island;
    }

    @Override
    public void run()  {

        try {
            MaxCapacity capacityAnnotation = creatureClass.getAnnotation(MaxCapacity.class);
            int quantity = Randomizer.random(0, capacityAnnotation.value() * island.getWidth()
                    * island.getHeight());
            for (int i = 0; i <= quantity; i++) {
                Animal animal = (Animal) creatureClass.getConstructor(Coordinates.class, Island.class)
                        .newInstance(CoordinatesGenerator.generateCoordinates(), island);
                animal.getThisPosition(animal.getPosition());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
