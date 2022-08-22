package creatures.animals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import creatures.Creature;
import behavior.Breeding;
import behavior.Eating;
import behavior.Moving;
import helper.AnimalCharacteristics;
import helper.EatingChance;
import helper.Randomizer;
import helper.Settings;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public abstract class Animal extends Creature implements Eating, Moving, Breeding {

    protected int starve = Island.getInstance().getSettings().getStarve();;
    protected List<Cell> accessibleCells = new ArrayList<>();
    public List<String> logList = new ArrayList<>();
    AnimalCharacteristics[] animalCharacteristics = Settings.initialize().getAnimalCharacteristics();

    protected Animal(Coordinates position) {
        super(position);
        this.initializeAccessibleCells();
    }

    public Animal(int x, int y) {
        super(new Coordinates(x,y));
        initializeAccessibleCells();
    }
    @Override
    public void moveTo(Cell newCell) {
        reduceEnergy();
        logList.add("Начинает движение в клетку " + newCell.getCoordinates());
        if (getCurrentEnergy().get() < 0) {
            throw new RuntimeException("Нет доступных очков хода");
        }
        leaveCell();
        newCell.addAnimalInCell(this);
        setPosition(newCell.getCoordinates());
        initializeAccessibleCells();
        logList.add("Закончил перемещение");
    }

    @Override
    public void breed() {
        logList.add("Начат процесс спаривания");
        List<Animal> breeders = chooseForBreed();
        if (!breeders.isEmpty()) {
            Animal animal = breeders.get(Randomizer.randomize(0, breeders.size()));
            try {
                Island.getInstance().addCreature(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                     InstantiationException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
            animal.reduceEnergy();
            this.reduceEnergy();
        } else {
            moveTo(choosingDirectionForBreed());
        }
        logList.add("Процесс спаривания завершен");
    }

    public abstract Cell choosingDirectionForEat();

    public Cell choosingDirectionForBreed() {
        return getAccessibleCells().stream()
                .filter(e -> e.getCurrentCapacityOfCell()
                        .containsKey(getName()))
                .findFirst()
                .orElse(accessibleCells.get(Randomizer.randomize(0, accessibleCells.size())));

    }
    public List<Animal> chooseForBreed() {
        Cell cell = Island.getInstance().getCell(getPosition());
        return cell.getFauna().stream().filter(e -> e.getName().equals(getName())
                && !(e.equals(this)) && e.getCurrentEnergy().get() > 0).toList();
    }


    public Animal chooseVictim(List<Animal> accessibleAnimals) {
        return accessibleAnimals.stream()
                .max(Comparator.comparing(Creature::getWeight))
                .orElse(accessibleAnimals
                        .get(Randomizer.randomize(0, accessibleAnimals.size())));
    }

    public void tryToEat(Animal victim) {
        Integer luck = EatingChance.getEatingChance(this.getClass().getAnnotation(EatingChanceNumber.class).value(),
                victim.getClass().getAnnotation(EatingChanceNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
            this.setCurrentHanger(getCurrentHanger() + victim.getWeight());
            this.setStarve(3);
            if (this.getCurrentHanger() > this.getMaxHunger()) {
                this.setCurrentHanger(getMaxHunger());
            }
            victim.dead();
        }
    }

    private void initializeAccessibleCells() {
        accessibleCells.clear();
        Coordinates coordinates = this.getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < Island.getInstance().getXSize()) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < Island.getInstance().getYSize()) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }

    @Override
    public void leaveCell() {
        {
            Cell cell = Island.getInstance().getCell(this.getPosition());
            cell.getFauna().remove(this);
            cell.getCurrentCapacityOfCell().merge(getName(), 1, Integer::sum);

            if (cell.getCurrentCapacityOfCell().get(getName()) >= getClass()
                    .getAnnotation(MaxCapacityInCell.class).value()) {
                cell.getCurrentCapacityOfCell().remove(getName());
            }
            cell.removeThis(this);
        }
    }

    public void act() {
        if (getCurrentHanger() < getMaxHunger() * 0.5) {
            logList.add("Процесс поедания начат");
            eat();
            logList.add("Процесс поедания завершен");
        } else {
            breed();
        }
    }

    public void init() {
        for (AnimalCharacteristics animal : animalCharacteristics ) {
            if (animal.getName().equals(this.getName())) {
                weight = animal.getWeight();
                maxEnergy = animal.getMaxEnergy();

                maxHunger = animal.getMaxHunger();
                currentEnergy = new AtomicInteger(animal.getCurrentEnergy());

                currentHanger = animal.getCurrentHunger();
            }
        }

    }
}
