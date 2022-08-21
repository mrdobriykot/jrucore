package creatures.animals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import creatures.Creature;
import behavior.Breeding;
import behavior.Eating;
import behavior.Moving;
import helper.EatingChance;
import helper.Randomizer;
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

@Getter
@Setter
public abstract class Animal extends Creature implements Eating, Moving, Breeding {

    protected int starve = 3;
    protected List<Cell> accessibleCells = new ArrayList<>();

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
        if (getCurrentEnergy().get() < 0) {
            throw new RuntimeException("Нет доступных очков хода");
        }
        leaveCell();
        //System.out.println(this + " перешел в клетку " + newCell.getCoordinates());
        newCell.addAnimalInCell(this);
        setPosition(newCell.getCoordinates());
        initializeAccessibleCells();
    }

    @Override
    public void breed() {
        List<Animal> breeders = chooseForBreed();
        if (!breeders.isEmpty()) {
            Animal animal = breeders.get(Randomizer.randomize(0, breeders.size()));
            try {
                Island.instance.addCreature(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
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
    }

    public Cell choosingDirectionForBreed() {
        return getAccessibleCells().stream()
                .filter(e -> e.getCurrentCapacityOfCell()
                        .containsKey(getName()))
                .findFirst()
                .orElse(accessibleCells.get(Randomizer.randomize(0, accessibleCells.size())));

    }
    public List<Animal> chooseForBreed() {
        Cell cell = Island.instance.getCell(getPosition());
        return cell.getFauna().stream().filter(e -> e.getName().equals(getName())
                && !(e.equals(this)) && e.getCurrentEnergy().get() > 0).toList();
    }



    public Animal chooseVictim() {
        Cell cell = Island.instance.getCell(this.getPosition());
        List<Animal> accessibleAnimals = cell.getFauna().stream()
                .filter(e -> EatingChance.getEatingChance(this
                                .getClass()
                                .getAnnotation(EatingChanceNumber.class)
                                .value(),
                        e.getClass()
                                .getAnnotation(EatingChanceNumber.class).value()) > 0)
                .toList();
        return accessibleAnimals.stream().max(Comparator.comparing(Creature::getWeight))
                .orElse(accessibleAnimals.get(ThreadLocalRandom.current()
                        .nextInt(0, accessibleAnimals.size())));
    }

    public void tryToEat(Animal victim) {
        Integer luck = EatingChance.getEatingChance(this.getClass().getAnnotation(EatingChanceNumber.class).value(),
                victim.getClass().getAnnotation(EatingChanceNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
            //System.out.println(String.format("%s съел %s", this.getName(), victim.getName()));
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
            accessibleCells.add(Island.instance.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < Island.instance.getXSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < Island.instance.getYSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }

    @Override
    public void leaveCell() {
        {
            Cell cell = Island.instance.getCell(this.getPosition());
            cell.getFauna().remove(this);
            cell.getCurrentCapacityOfCell().merge(getName(), 1, Integer::sum);

            if (cell.getCurrentCapacityOfCell().get(getName()) >= getClass()
                    .getAnnotation(MaxCapacityInCell.class).value()) {
                cell.getCurrentCapacityOfCell().remove(getName());
            }
            cell.removeThis(this);
        }
    }
}
