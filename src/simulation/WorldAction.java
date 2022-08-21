package simulation;

import island.Cell;
import island.Island;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorldAction implements Runnable{
    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream()
                            .filter(e -> e.getCurrentEnergy().get() > 0)
                            .forEach(e -> service.submit(new AnimalBehavior(e)));
                }
            }
        }
    }
}
