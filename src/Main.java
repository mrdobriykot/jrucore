import creatures.animals.herbivoreanimals.Horse;
import island.Cell;
import island.Island;
import simulation.AnimalBehavior;
import simulation.AnimalCreation;
import simulation.GrassCreation;
import simulation.WorldAction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        AnimalCreation.creationOfAnimal();
//        Thread grass = new Thread(new GrassCreation());
//        grass.start();
//        try {
//            grass.join();
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted");
//        }
//        System.out.println("Животные и растения на своих местах. Начать симуляцию?");
//        scanner.nextLine();
//
//        Thread act = new Thread(new WorldAction());
//        act.start();
//        try {
//            act.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Cell cell = Island.instance.getCell(20, 19);

        Horse horse1 = new Horse(20, 18);
        Horse horse2 = new Horse(20,19);

        Island.instance.addCreature(horse1);
        Island.instance.addCreature(horse2);

        System.out.println(Island.instance.getCell(horse2.getPosition()).getHerbivoreQty());

        new AnimalBehavior(horse1).run();
        System.out.println(Island.instance.getCell(20, 19));
    }
}
