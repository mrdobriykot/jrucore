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
    ScheduledExecutorService grassService = Executors.newScheduledThreadPool(1);
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        grassService.scheduleAtFixedRate(new GrassCreation(), 0, 5, TimeUnit.MINUTES);
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
            if (printer.herbivoresQuantity == 0 || printer.carnivoresQuantity == 0) {
                apocalypse();
            }
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

        try {
            grassService.shutdown();
            grassService.awaitTermination(3, TimeUnit.SECONDS);
            grassService.shutdownNow();
            cachedService.shutdown();
            cachedService.awaitTermination(3, TimeUnit.SECONDS);
            cachedService.shutdownNow();
            service.awaitTermination(3, TimeUnit.SECONDS);
            service.shutdownNow();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());;
        }
    }
}
