package simulation;

import creatures.animals.carnivoreanimals.*;
import creatures.animals.herbivoreanimals.*;
import island.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FaunaMovement {
    public static void movement() {
        List<Runnable> listOfTasks = new ArrayList<>();

        listOfTasks.add(new AnimalCreation(Bear.class));
        listOfTasks.add(new AnimalCreation(Snake.class));
        listOfTasks.add(new AnimalCreation(Eagle.class));
        listOfTasks.add(new AnimalCreation(Fox.class));
        listOfTasks.add(new AnimalCreation(Wolf.class));
        listOfTasks.add(new AnimalCreation(Boar.class));
        listOfTasks.add(new AnimalCreation(Buffalo.class));
        listOfTasks.add(new AnimalCreation(Caterpiller.class));
        listOfTasks.add(new AnimalCreation(Deer.class));
        listOfTasks.add(new AnimalCreation(Duck.class));
        listOfTasks.add(new AnimalCreation(Goat.class));
        listOfTasks.add(new AnimalCreation(Horse.class));
        listOfTasks.add(new AnimalCreation(Mouse.class));
        listOfTasks.add(new AnimalCreation(Rabbit.class));
        listOfTasks.add(new AnimalCreation(Sheep.class));


        ExecutorService service = Executors.newCachedThreadPool();

        for (Runnable task : listOfTasks) {
            System.out.println(service.submit(task));
        }

        service.shutdown();

        Island.instance.getIslandInfo();
    }
}
