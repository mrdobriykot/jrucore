package creatures.animals;

import annotation.MaxCapacity;
import creatures.Creature;
import interfaces.Breed;
import interfaces.*;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;
import settings.AnimalCharacteristics;
import settings.EatChanceTable;

import java.util.ArrayList;
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
        setCoordinates(newCell.getCoordinates());
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

}
