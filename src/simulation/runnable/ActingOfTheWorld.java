package simulation.runnable;

import helper.ExecutorsAwaitingConstants;
import helper.StatisticPrinter;
import island.Cell;
import island.Island;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ActingOfTheWorld implements Runnable {
    public static final String START_MESSAGE = "Animals move...";
    public static final String END_MESSAGE = "End of the day...";
    public static final int QUANTITY_OF_THREADS = 5;
    public Island island;
    public StatisticPrinter printer = new StatisticPrinter();

    public ExecutorService service = Executors.newFixedThreadPool(QUANTITY_OF_THREADS);

    public ActingOfTheWorld(Island island) {
        this.island = island;
    }

    public void run() {
        System.out.println(START_MESSAGE);
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Cell cell = island.getCell(x, y);
                if (!cell.getFauna().isEmpty()) {
                    service.submit(new DayInCellProc(cell));
                }
            }
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(ExecutorsAwaitingConstants.ACT_OF_WORLD_AWAITING, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e + " WorldActingInterrupted");
        }
        System.out.println(END_MESSAGE);
        printer.print();
    }
}
