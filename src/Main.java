import simulation.AnimalCreation;
import simulation.GrassCreation;
import simulation.WorldAction;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Start().startSimulation();
    }
}