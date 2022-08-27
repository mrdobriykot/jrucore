package simulation.executors;

import creatures.animals.carnivore.*;
import creatures.animals.herbivore.*;
import helper.ExecutorsAwaitingConstants;
import island.Island;
import simulation.runnable.AnimalDeployer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FaunaCreation {
    Island island;

    public static final String ANIMAL_DEPLOYING_MESSAGE = "Waiting for animal deploying";
    public static final String END_OF_DEPLOYING_MESSAGE = "Animal deployed";
    private List<Runnable> tasks = new ArrayList<>();

    public FaunaCreation(Island island) {
        this.island = island;
    }

    public void creation() {
        tasks.add(new AnimalDeployer(Bear.class, island));
        tasks.add(new AnimalDeployer(Snake.class, island));
        tasks.add(new AnimalDeployer(Eagle.class, island));
        tasks.add(new AnimalDeployer(Fox.class, island));
        tasks.add(new AnimalDeployer(Wolf.class, island));
        tasks.add(new AnimalDeployer(Boar.class, island));
        tasks.add(new AnimalDeployer(Buffalo.class, island));
        tasks.add(new AnimalDeployer(Caterpillar.class, island));
        tasks.add(new AnimalDeployer(Deer.class, island));
        tasks.add(new AnimalDeployer(Duck.class, island));
        tasks.add(new AnimalDeployer(Goat.class, island));
        tasks.add(new AnimalDeployer(Horse.class, island));
        tasks.add(new AnimalDeployer(Mouse.class, island));
        tasks.add(new AnimalDeployer(Rabbit.class, island));
        tasks.add(new AnimalDeployer(Sheep.class, island));

        ExecutorService service = Executors.newWorkStealingPool();


        tasks.stream()
                .forEach(e ->service.submit(e));

        try {
            System.out.println(ANIMAL_DEPLOYING_MESSAGE);
            service.shutdown();
            if (!service.awaitTermination(ExecutorsAwaitingConstants.FAUNA_IMMIGRATE_AWAITING, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
            System.out.println(END_OF_DEPLOYING_MESSAGE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
