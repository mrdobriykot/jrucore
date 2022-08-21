package simulation;

import island.Cell;
import island.Island;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorldAction implements Runnable{

    ExecutorService service = Executors.newSingleThreadExecutor();

    public void run() {
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream().forEach(e -> System.out.println(service.submit(new AnimalBehavior(e))));
                }
            }
        }
    }
}
