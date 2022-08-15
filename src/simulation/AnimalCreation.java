package simulation;

import annotation.MaxCapacity;
import creatures.Creature;
import helpers.CoordinatesGenerator;
import island.Coordinates;
import island.Island;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalCreation implements Runnable{
    Class creatureClass;
    int islandLength = Island.instance.getXSize();
    int islandWidth = Island.instance.getYSize();

    public AnimalCreation(Class<?> clazz) {
        this.creatureClass = clazz;
    }

    @Override
    public void run()  {

        try {
            MaxCapacity capacityAnnotation = (MaxCapacity) creatureClass.getAnnotation(MaxCapacity.class);
            int capacity = ThreadLocalRandom.current().nextInt(0, capacityAnnotation.value() * islandLength*islandWidth);
            for (int i = 0; i <= capacity; i++) {
                Island.instance.addCreature((Creature) creatureClass.getConstructor(Coordinates.class)
                        .newInstance(CoordinatesGenerator.generateCoordinates()));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
