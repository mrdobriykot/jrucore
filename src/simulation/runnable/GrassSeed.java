package simulation.runnable;

import creatures.plants.Plants;
import helper.Randomizer;
import island.Cell;
import island.Island;

import java.time.LocalTime;

public class GrassSeed implements Runnable {
    private final String START_MESSAGE = "Planting grass...";
    Island island;

    public GrassSeed(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        System.out.println(LocalTime.now() + " " + START_MESSAGE);
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Cell cell = island.getCell(x, y);
                if (cell.getFlora().size() < 200) {
                    int targetQuantityOfGrass = Randomizer.random(0, 200);
                    if (cell.getFlora().size() < targetQuantityOfGrass) {
                        for (int k = 0; k < targetQuantityOfGrass; k++) {
                            cell.addPlantInCell(new Plants(cell.getCoordinates(), island));
                        }
                    }
                }
            }
        }
    }
}
