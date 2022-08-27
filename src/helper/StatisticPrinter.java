package helper;

import interfaces.Printer;
import island.Cell;
import island.Island;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class StatisticPrinter implements Printer {

    public static final String NAME_OF_THREAD = "Statistics";
    public Map<String, Long> quantityOfAnimals = new ConcurrentHashMap<>();
    public Map<String, Long> quantityOfPlants = new ConcurrentHashMap<>();
    public AtomicInteger carnivoresQuantity = new AtomicInteger(0);
    public AtomicInteger herbivoresQuantity = new AtomicInteger(0);
    private ExecutorService service = Executors.newSingleThreadExecutor();
    private static final String CARNIVORES_DEAD = "All carnivores are down. Please, stop tormenting this cursed world.";
    private static final String HERBIVORES_DEAD = "All herbivores died. We recommend that you stop torturing this weak world.";

    private Island island = Island.getInstance();

    @Override
    public void print() {
        Thread.currentThread().setName(NAME_OF_THREAD);
        quantityOfPlants.clear();
        quantityOfAnimals.clear();
        carnivoresQuantity.set(0);
        herbivoresQuantity.set(0);

        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Cell cell = island.getCell(x, y);
                service.submit(() -> {
                    cell.getCreaturesInCell().entrySet().stream().forEach(e -> quantityOfAnimals.merge(e.getKey(), e.getValue(), (o, n) -> o + n));
                    cell.getQuantityOfGrass().entrySet().stream().forEach(e -> quantityOfPlants.merge(e.getKey(), e.getValue(), (o, n) -> o + n));
                    carnivoresQuantity.addAndGet(cell.getCarnivoreQuantity());
                    herbivoresQuantity.addAndGet(cell.getHerbivoreQuantity());
                });
            }
        }
        try {
            service.awaitTermination(ExecutorsAwaitingConstants.STATISTIC_PRINTER_AWAITING, TimeUnit.SECONDS);
            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e + " " + "StatisticsPrinter is interrupted");
        }
        quantityOfAnimals.forEach((k,v)->System.out.println(k +" : "+v ));
        System.out.println();
        quantityOfPlants.forEach((k,v)->System.out.println(k +" : "+v ));
        if (carnivoresQuantity.get() == 0) {
            System.out.println(CARNIVORES_DEAD);

        } else if (herbivoresQuantity.get() == 0) {
            System.out.println(HERBIVORES_DEAD);
        }
    }
}
