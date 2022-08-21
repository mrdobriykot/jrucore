package island;

import annotation.MaxCapacityInCell;
import creatures.Creature;
import creatures.animals.Animal;
import creatures.animals.carnivoreanimals.CarnivoreAnimal;
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
    private Map<String, Long> animalsInCell = new ConcurrentHashMap<>();
    private Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();
    private Map<String, Long> qtyOfGrass = new ConcurrentHashMap<>();
    private List<Animal> fauna = new CopyOnWriteArrayList<>();
    private List<Plant> flora = new CopyOnWriteArrayList<>();


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }
    public void addAnimalInCell(Animal animal) {
        fauna.add(animal);
        animalsInCell.merge(animal.getName(), 1L, Long::sum);
        updateCapacity(animal);
        if (currentCapacityOfCell.get(animal.getName()) <=0 ){
            //System.err.println(String.format("%s погиб, нет места"));
            animal.dead();
        }
    }

    private void updateCapacity(Creature creature) {
        currentCapacityOfCell.putIfAbsent(creature.getName(), creature.getClass()
                .getAnnotation(MaxCapacityInCell.class).value());
        currentCapacityOfCell.merge(creature.getName(), 1, (oldVal, newVal) -> oldVal - newVal);
    }

    public void addPlantInCell(Plant plant) {
        flora.add(plant);
        qtyOfGrass.merge(plant.getName(), 1L, Long::sum);
        //animalsInCell.merge(plant.getName(), 1L, Long::sum);
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

    public Integer getPlantsQty() {
        return flora.size();
    }


    public void removeThis(Creature creature) {
        animalsInCell.merge(creature.getName(), 1L, (oldVal, newVal) -> oldVal - newVal);
        if (animalsInCell.get(creature.getName()) < 0 || animalsInCell.get(creature.getName()) != null ) {
            animalsInCell.remove(creature.getName());
        }
    }
    public void killAll() {
        fauna.stream().forEach(Creature::dead);
        flora.stream().forEach(Creature::dead);
    }

}
