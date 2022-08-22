package simulation;


import annotation.MaxCapacityInCell;
import creatures.Creature;
import creatures.animals.Animal;
import helper.CoordinatesGenerator;
import helper.Settings;
import island.Coordinates;
import island.Island;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalDeploy implements Runnable {
    Class creatureClass;
    int islandLength = Island.getInstance().getXSize();
    int islandWidth = Island.getInstance().getYSize();


    public AnimalDeploy(Class<?> clazz) {
        this.creatureClass = clazz;
    }


    @Override
    public void run() {

        try {
            MaxCapacityInCell capacityAnnotation = (MaxCapacityInCell) creatureClass.getAnnotation(MaxCapacityInCell.class);
            int quantity = ThreadLocalRandom.current()
                    .nextInt(0, capacityAnnotation.value() * islandLength * islandWidth);
            for (int i = 0; i <= quantity; i++) {
                Island.getInstance().addCreature((Animal) creatureClass.getConstructor(Coordinates.class)
                        .newInstance(CoordinatesGenerator.generateCoordinates()));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

