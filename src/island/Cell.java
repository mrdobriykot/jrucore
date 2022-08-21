package island;

import annotation.MaxCapacityInCell;
import creatures.Creature;
import creatures.animals.Animal;
import creatures.animals.carnivoreanimals.CarnivoreAnimal;
import creatures.animals.herbivoreanimals.Caterpillar;
import creatures.animals.herbivoreanimals.HerbivoreAnimal;
import creatures.grass.Plant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ToString
@Setter
@Getter
public class Cell {

    @ToString.Exclude
    //private final File JSON_ANIM_QTY = new File("/src/configfiles/capacityofCell.json");
    private Coordinates coordinates = new Coordinates();
    protected Map<String, Long> animalsInCell = new ConcurrentHashMap<>();
    protected Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();
    protected List<Animal> fauna = new CopyOnWriteArrayList<>();
    protected List<Plant> flora = new CopyOnWriteArrayList<>();


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }
    public synchronized void addAnimalInCell(Animal animal) {
        fauna.add(animal);
        animalsInCell.merge(animal.getName(), 1L, Long::sum);
        updateCapacity(animal);
        if (currentCapacityOfCell.get(animal.getName()) <=0 ){
            System.err.println(String.format("%s погиб, нет места"));
            animal.dead();
        }
    }

    private void updateCapacity(Creature creature) {
        currentCapacityOfCell.putIfAbsent(creature.getName(), creature.getClass()
                .getAnnotation(MaxCapacityInCell.class).value());
        currentCapacityOfCell.merge(creature.getName(), 1, (oldVal, newVal) -> oldVal - newVal);
    }

    public synchronized void addPlantInCell(Plant plant) {
        flora.add(plant);
        animalsInCell.merge(plant.getName(), 1L, Long::sum);
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
        return fauna.stream()
                .filter(creature -> creature instanceof HerbivoreAnimal)
                .toList()
                .size();
    }

}
