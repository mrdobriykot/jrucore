import island.Island;
import simulation.RunSimulation;

import java.util.Arrays;

public class Main {
    public static final String END_MESSAGE = "Ended";
    public static void main(String[] args) {
        new RunSimulation(Island.getInstance()).startSimulation();
        System.out.println(END_MESSAGE);
    }
}
