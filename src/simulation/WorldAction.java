package simulation;

import island.Cell;
import island.Island;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorldAction implements Runnable{
    Island island = Island.getInstance();
    public void run() {
        System.out.println("Животные начинают движение...");
        for (int x = 0; x < island.getXSize(); x++) {
            for (int y = 0; y < island.getYSize(); y++) {
                Cell cell = island.getCell(x, y);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream()
                            .forEach(e -> {
                                while (e.getCurrentEnergy().get() > 0) {
                                    e.act();
                                }
                            });
                }
            }
        }
        System.out.println("День окончен!");
    }
}
