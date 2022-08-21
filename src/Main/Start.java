package Main;

import creatures.Creature;
import helper.PrintStatistic;
import island.Cell;
import island.Island;
import simulation.AnimalCreation;
import simulation.GrassCreation;
import simulation.WorldAction;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Start implements Runnable {
    private int day = 0;
    private PrintStatistic printer = new PrintStatistic();
    ExecutorService service = Executors.newSingleThreadExecutor();
    ExecutorService cachedService = Executors.newCachedThreadPool();
    ScheduledExecutorService grassService = Executors.newScheduledThreadPool(3);

    @Override
    public void run() {
        grassService.scheduleAtFixedRate(new GrassCreation(), 0, 1, TimeUnit.MINUTES);
        Scanner scanner = new Scanner(System.in);
        new AnimalCreation().creationOfAnimal();
        System.out.println("Животные и растения на своих местах. Начать симуляцию? Y/N");
        String answer = scanner.nextLine();
        if ("Y".equals(answer)) {
            while (true) {
                Thread actionThread = new Thread(new WorldAction());
                actionThread.start();
                try {
                    actionThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(String.format("День %d окончен, состояние острова:", ++day));
                printer.print();
                System.out.println("Начать новый день?");
                answer = scanner.nextLine();
                if ("Yes".equalsIgnoreCase(answer)) {
                    startNewDay();
                } else {
                    apocalypse();
                    break;
                }
            }
        }
        if (printer.herbivoresQuantity == 0 || printer.carnivoresQuantity == 0) {
            apocalypse();
        }
    }

    public synchronized void startNewDay() {
        System.out.println("Начинаем новый день!");
        cachedService.submit(() -> Arrays.stream(Island.instance.getField())
                .forEach(cell-> Arrays.stream(cell)
                        .forEach(animal -> animal.getFauna()
                                .forEach(Creature::restoreEnergy))));

    }

    private void apocalypse() {
        //Arrays.stream(Island.instance.getField()).forEach(e-> Arrays.stream(e).forEach(Cell::killAll));

        grassService.shutdown();
        grassService.shutdownNow();
        cachedService.shutdown();
        cachedService.shutdownNow();
        service.shutdownNow();
    }
}
