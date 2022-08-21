import creatures.Creature;
import helper.PrintStatistic;
import interfaces.Printer;
import island.Island;
import simulation.AnimalCreation;
import simulation.GrassCreation;
import simulation.WorldAction;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Start {
    private int day = 0;
    private Printer printer = new PrintStatistic();
    ExecutorService service = Executors.newSingleThreadExecutor();
    ScheduledExecutorService grassService = Executors.newScheduledThreadPool(3);

    public void startSimulation() {
        grassService.scheduleAtFixedRate(new GrassCreation(), 0, 5, TimeUnit.MINUTES);
        Scanner scanner = new Scanner(System.in);
        AnimalCreation.creationOfAnimal();
        System.out.println("Животные и растения на своих местах. Начать симуляцию? Y/N");
        String answer = scanner.nextLine();
        if ("Y".equals(answer)) {
            while (true) {
                service.submit(new WorldAction());
                System.out.println(String.format("День %d окончен, состояние острова:", ++day));
                printer.print();
                System.out.println("Начать новый день?");
                answer = scanner.nextLine();
                if ("N".equalsIgnoreCase(answer)) {
                    break;
                }
                startNewDay();
            }
            grassService.shutdown();
        }
    }

    public void startNewDay() {
        System.out.println("Начинаем новый день!");
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Island.instance.getCell(i, j).getFauna().stream().forEach(Creature::restoreEnergy);
            }
        }
    }
}
