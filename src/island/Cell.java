package island;

import annotation.MaxCapacityInCell;
import creatures.Creature;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ToString
public class Cell {
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
        animalsInCell = fauna.stream().collect(Collectors.groupingBy(e -> e.getName(), Collectors.counting()));
        capacityOfCellInit(creature);
        if (currentCapacityOfCell.get(creature.getName()) < 0) {
            creature.dead();
            System.err.println(String.format("Новый %s не смог появиться в этом месте, для него нет места. От безысходности он сразу умирает.", creature.getName()));
        }
    }

    private synchronized void capacityOfCellInit(Creature creature) {
        if (!currentCapacityOfCell.containsKey(creature.getName())) {
            currentCapacityOfCell.put(creature.getName(), creature.getClass().getAnnotation(MaxCapacityInCell.class).value() - 1);
        } else {
            currentCapacityOfCell.put(creature.getName(), currentCapacityOfCell.get(creature.getName()) - 1);
        }
    }
}
