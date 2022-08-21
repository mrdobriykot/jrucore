package creatures.animals;

import annotation.EatingChanceNumber;
import creatures.Creature;
import behavior.Breeding;
import behavior.Eating;
import behavior.Moving;
import helper.EatingChance;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Animal extends Creature implements Eating, Moving, Breeding {

    protected int starve = 3;

    protected Animal(Coordinates position) {
        super(position);
    }

    public Animal(int x, int y) {
        super(new Coordinates(x,y));
    }
    @Override
    public void moveTo(Cell newCell) {
        this.currentEnergy--;
        this.leaveCell();
        System.out.println(this + " перешел в клетку " + newCell.getCoordinates());
        newCell.addAnimalInCell(this);
    }

    @Override
    public void breed(Animal animal) {
        try {
            Island.instance.addCreature(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        animal.currentEnergy--;
        this.currentEnergy--;
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
        return accessibleAnimals.stream().max(Comparator.comparing(Creature::getWeight)).orElseGet(this::chooseVictim);
    }

    public void tryToEat(Animal victim) {
        Integer luck = EatingChance.getEatingChance(this.getClass().getAnnotation(EatingChanceNumber.class).value(),
                victim.getClass().getAnnotation(EatingChanceNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
            System.out.println(String.format("%s съел %s", this.getName(), victim.getName()));
            this.currentHanger += victim.getWeight();
            this.setStarve(3);
            if (this.currentHanger > this.maxHunger) {
                this.currentHanger = this.maxHunger;
            }
            victim.dead();
        } else {
            System.out.println(String.format("%s не смог съесть %s", this.getName(), victim.getName()));
        }
    }
}
