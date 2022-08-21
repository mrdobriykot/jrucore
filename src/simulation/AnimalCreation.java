package simulation;

import creatures.animals.carnivoreanimals.*;
import creatures.animals.herbivoreanimals.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnimalCreation {
    private List<Runnable> listOfTask = new ArrayList<>();
    public void creationOfAnimal() {

        listOfTask.add(new AnimalDeploy(Bear.class));
        listOfTask.add(new AnimalDeploy(Eagle.class));
        listOfTask.add(new AnimalDeploy(Fox.class));
        listOfTask.add(new AnimalDeploy(Snake.class));
        listOfTask.add(new AnimalDeploy(Wolf.class));
        listOfTask.add(new AnimalDeploy(Boar.class));
        listOfTask.add(new AnimalDeploy(Buffalo.class));
        listOfTask.add(new AnimalDeploy(Caterpillar.class));
        listOfTask.add(new AnimalDeploy(Deer.class));
        listOfTask.add(new AnimalDeploy(Duck.class));
        listOfTask.add(new AnimalDeploy(Goat.class));
        listOfTask.add(new AnimalDeploy(Horse.class));
        listOfTask.add(new AnimalDeploy(Mouse.class));
        listOfTask.add(new AnimalDeploy(Rabbit.class));
        listOfTask.add(new AnimalDeploy(Sheep.class));


        ExecutorService executorService = Executors.newCachedThreadPool();
        listOfTask.stream().forEach(e -> executorService.submit(e));

        executorService.shutdown();

        //Island.instance.getIslandInfo();

    }
}
