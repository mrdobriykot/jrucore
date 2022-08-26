package island;

import annotation.MaxCapacity;
import creatures.Creature;
import creatures.animals.Animal;
import creatures.animals.carnivore.CarnivoreAnimal;
import creatures.animals.herbivore.HerbivoreAnimal;
import creatures.plants.Plants;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
public class Cell {
    private Coordinates coordinates = new Coordinates();
    private Map<String, Long> creaturesInCell = new ConcurrentHashMap<>();
    private Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();
    private Map<String, Long> quantityOfGrass = new ConcurrentHashMap<>();

    private List<Animal> fauna = new CopyOnWriteArrayList<>();
    private List<Plants> flora = new CopyOnWriteArrayList<>();

    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public void addAnimalInCell(Animal animal) {
        fauna.add(animal);
        creaturesInCell.merge(animal.getEmoji(), 1L, Long::sum);
        updateCapacity(animal);
        if (currentCapacityOfCell.get(animal.getEmoji()) <=0 ){
            animal.die();
        }
    }
    private void updateCapacity(Creature creature) {
        currentCapacityOfCell.putIfAbsent(creature.getEmoji(), creature.getClass().getAnnotation(MaxCapacity.class).value());
        currentCapacityOfCell.merge(creature.getEmoji(), 1, (oldVal, newVal) -> oldVal - newVal);
    }

    public void addPlantInCell(Plants plant) {
        flora.add(plant);
        quantityOfGrass.merge(plant.getEmoji(), 1L, Long::sum);
    }


    public void removeThis(Creature creature) {
        creaturesInCell.merge(creature.getEmoji(), 1L, (oldVal, newVal) -> oldVal - newVal);
        if (creaturesInCell.get(creature.getEmoji()) < 0 || creaturesInCell.containsKey(creature.getEmoji())) {
            creaturesInCell.remove(creature.getEmoji());
        }
    }
    public Integer getHerbivoreQuantity() {
        return fauna.stream()
                .filter(HerbivoreAnimal.class::isInstance)
                .toList()
                .size();
    }
    public Integer getCarnivoreQuantity() {
        return fauna.stream()
                .filter(CarnivoreAnimal.class::isInstance)
                .toList()
                .size();
    }

    public Integer getPlantsQuantity() {
        return flora.size();
    }
    private void killAll() {
        fauna.stream().forEach(Creature::die);
        flora.stream().forEach(Creature::die);
    }
}
