package island;

import annotation.MaxCapacityInCell;
import creatures.Creature;
import creatures.animals.carnivoreanimals.CarnivoreAnimal;
import creatures.animals.herbivoreanimals.Caterpillar;
import creatures.animals.herbivoreanimals.HerbivoreAnimal;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ToString
@Getter
public class Cell {

    @ToString.Exclude
    private final File JSON_ANIM_QTY = new File("/src/configfiles/capacityofCell.json");
    private Coordinates coordinates = new Coordinates();
    protected Map<String, Long> animalsInCell = new ConcurrentHashMap<>();
    protected Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();
    protected List<Creature> fauna = new CopyOnWriteArrayList<>();


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }
    public synchronized void addCreatureInCell (Creature creature) {
        fauna.add(creature);
        animalsInCell.merge(creature.getName(), 1L, Long::sum);
        currentCapacityOfCell.putIfAbsent(creature.getName(), creature.getClass()
                .getAnnotation(MaxCapacityInCell.class).value());
        currentCapacityOfCell.merge(creature.getName(), 1, (oldVal, newVal) -> oldVal -newVal);
        if (currentCapacityOfCell.get(creature.getName()) <= 0) {
            System.err.println(String.format("Новый %s не смог появиться в этом месте, для него нет места. " +
                    "От безысходности он сразу умирает.", creature.getName()));
            creature.dead();
        }
    }

    private synchronized void capacityOfCellInit(Creature creature) {
        currentCapacityOfCell.compute(creature.getName(), (k, v) -> currentCapacityOfCell.get(k) -1);
    }

    public Integer getCarnivoreQty() {
        return fauna.stream().filter(creature -> creature instanceof CarnivoreAnimal)
                .collect(Collectors.toList())
                .size();
    }

    public Integer getHerbivoreQty() {
        return fauna.stream().filter(creature -> creature instanceof HerbivoreAnimal && !(creature instanceof Caterpillar))
                .collect(Collectors.toList())
                .size();
    }

}
