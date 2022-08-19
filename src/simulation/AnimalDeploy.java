package simulation;


import annotation.MaxCapacityInCell;
import creatures.Creature;
import helper.CoordinatesGenerator;
import island.Coordinates;
import island.Island;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalDeploy implements Runnable{
    Class creatureClass;
    int islandLength = Island.instance.getXSize();
    int islandWidth = Island.instance.getYSize();


    public AnimalDeploy(Class<?> clazz) {
        this.creatureClass = clazz;
    }


    @Override
    public void run() {

        try {
            MaxCapacityInCell maxCapacityInCell = (MaxCapacityInCell) creatureClass.getAnnotation(MaxCapacityInCell.class);
            int capacity = ThreadLocalRandom.current().nextInt(0, maxCapacityInCell.value() * islandLength
                    * islandWidth);
            for (int i = 0; i <= capacity; i++) {
                Island.instance.addCreature((Creature) creatureClass.getConstructor(Coordinates.class)
                        .newInstance(CoordinatesGenerator.generateCoordinates()));
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
