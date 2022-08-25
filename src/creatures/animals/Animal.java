package creatures.animals;

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
    protected AnimalCharacteristics[] animalCharacteristics;

    public Animal(Coordinates coordinates, Island island) {
        super(coordinates, island);
        settings = island.getSettings();
        starve = settings.getStarve();
        animalCharacteristics = island.getAnimalCharacteristics();
    }

    public void init() {
        for (AnimalCharacteristics animal : animalCharacteristics) {
            if (animal.getName().equals(getName())) {
                weight = animal.getWeight();
                maxEnergy = animal.getMaxEnergy();
                maxHunger = animal.getMaxHunger();
                currentEnergy = animal.getCurrentEnergy();
                currentHanger = animal.getCurrentHunger();
                luck = EatChanceTable.getEatChanceTable().get(animal.getName());
                maxCapacity = animal.getMaxCapacity();
                emoji = animal.getEmoji();
                break;
            }
        }
    }

    @Override
    public void breed() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void moveTo(Cell newCell) {

    }
}
