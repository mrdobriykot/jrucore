package simulation;

import creatures.grass.Plant;
import island.Cell;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class GrassCreation implements Runnable{
    @Override
    public void run() {
        for (int x = 0; x < Island.instance.getXSize(); x++) {
            for (int y = 0; y < Island.instance.getYSize(); y++) {
                Cell cell = Island.instance.getCell(x, y);
                if (cell.getFlora().size() < 200) {
                    for (int k = 0; k < ThreadLocalRandom.current().nextInt(0, 201); k++) {
                        cell.addPlantInCell(new Plant(cell.getCoordinates()));
                    }
                }
            }
        }
    }
}
