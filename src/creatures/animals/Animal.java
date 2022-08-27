package creatures.animals;

import annotation.MaxCapacity;
import creatures.Creature;
import helper.Randomizer;
import interfaces.Breed;
import interfaces.*;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;
import settings.AnimalCharacteristics;
import settings.EatChanceTable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public abstract class Animal extends Creature implements Move, Eat, Breed {
    protected int starve;
    protected List<Cell> accessibleCell = new ArrayList<>();
    public List<String> logList = new ArrayList<>();
    protected AnimalCharacteristics[] animalCharacteristics;

    public Animal(Coordinates coordinates, Island island) {
        super(coordinates, island);
        settings = island.getSettings();
        starve = settings.getStarve();
        animalCharacteristics = island.getAnimalCharacteristics();
    }

    public Animal(int x, int y, Island island) {
        super(new Coordinates(x, y), island);
        settings = island.getSettings();
        starve = settings.getStarve();
        animalCharacteristics = island.getAnimalCharacteristics();
    }

    public abstract Cell choosingDirectionForEat();

    @Override
    public void moveTo(Cell newCell) {
        reduceEnergy();
        leaveCell();
        newCell.addAnimalInCell(this);
        setPosition(newCell.getCoordinates());
    }


    @Override
    public void breed() {
        List<Animal> breeders = chooseForBreed();
        if (!breeders.isEmpty()) {
            Animal parentAnimal = breeders.get(Randomizer.random(0, breeders.size()));
            bornNewAnimal(parentAnimal);
            parentAnimal.reduceEnergy();
            this.reduceEnergy();
        } else {
            initializeAccessibleCell();
            moveTo(choosingDirectionForBreed());
        }
    }


    public Cell choosingDirectionForBreed() {
        return getAccessibleCell().stream()
                .filter(e -> e.getCurrentCapacityOfCell()
                        .containsKey(getName()))
                .findFirst()
                .orElse(accessibleCell.get(Randomizer.random(0, accessibleCell.size())));

    }

    public List<Animal> chooseForBreed() {
        Cell cell = island.getCell(getPosition());
        return cell.getFauna().stream().filter(e -> e.getName().equals(getName())
                && !(e.equals(this)) && e.getCurrentEnergy().get() > 0 && e.currentHanger > e.maxHunger / 2).toList();
    }

    public Animal chooseVictim(List<Animal> accessibleAnimals) {

        return accessibleAnimals.stream()
                .max(Comparator.comparing(Creature::getWeight))
                .orElse(accessibleAnimals.get(Randomizer.random(0, accessibleAnimals.size())));
    }

    public void tryToEat(Animal victim) {
        Double luck = getLuck().get(victim.getName());
        if (Randomizer.random(0, 100) < luck) {
            this.setCurrentHanger(getCurrentHanger() + victim.getWeight());
            this.setStarve(settings.getStarve());
            if (this.getCurrentHanger() > this.getMaxHunger()) {
                this.setCurrentHanger(getMaxHunger());
            }
            victim.die();
        }
    }

    protected void initializeAccessibleCell() {
        accessibleCell.clear();
        Coordinates coordinates = getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCell.add(island.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCell.add(island.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < island.getWidth()) {
            accessibleCell.add(island.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < island.getHeight()) {
            accessibleCell.add(island.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }

    @Override
    public void leaveCell() {
        Cell cell = island.getCell(getPosition());
        cell.getFauna().remove(this);
        cell.getCurrentCapacityOfCell().merge(getEmoji(), 1, Integer::sum);

        if (cell.getCurrentCapacityOfCell().get(getName()) >= getClass().getAnnotation(MaxCapacity.class).value()) {
            cell.getCurrentCapacityOfCell().remove(getName());
        }
        cell.removeThis(this);
    }

    public void init() {
        for (AnimalCharacteristics animal : animalCharacteristics) {
            if (animal.getName().equals(getName())) {
                weight = animal.getWeight();
                maxEnergy = animal.getMaxEnergy();
                maxHunger = animal.getMaxHunger();
                currentEnergy.set(animal.getCurrentEnergy());
                currentHanger = animal.getCurrentHunger();
                luck = EatChanceTable.getEatChanceTable().get(animal.getName());
                maxCapacity = animal.getMaxCapacity();
                emoji = animal.getEmoji();
                break;
            }
        }
    }

    public void getThisPosition(Coordinates coordinates) {
        setCell(island.getCell(coordinates));
        cell.addAnimalInCell(this);
    }

    private void bornNewAnimal(Animal animal) {

        try {
            Animal newAnimal = this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition());
            newAnimal.getThisPosition(animal.getPosition());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 InstantiationException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
