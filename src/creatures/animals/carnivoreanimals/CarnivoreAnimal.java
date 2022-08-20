package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import creatures.Creature;
import creatures.animals.Animal;
import helper.EatingChance;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public abstract class CarnivoreAnimal extends Animal {

    public CarnivoreAnimal(Coordinates position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public Cell chooseDirection() {
        System.out.println(this + " выбирает направление");
        return this.getAccessibleCell().stream()
                .max(Comparator.comparing(Cell::getHerbivoreQty))
                .orElseGet(() -> Island.instance.getCell(this.getPosition()));
    }

    @Override
    public void moveTo(Cell newCell) {
        super.moveTo(newCell);
        this.energy--;
    }

    public Animal chooseVictim() {
        Cell cell = Island.instance.getCell(this.getPosition());
        return (Animal) cell.getFauna().stream().max(Comparator.comparing(Creature::getWeight)).orElseGet(null);
    }


    public void eat(Animal animal) {
        Integer luck = EatingChance.getEatingChance(this.getClass().getAnnotation(EatingChanceNumber.class).value(),
                animal.getClass().getAnnotation(EatingChanceNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
            System.out.println(String.format("%s съел %s", this.getName(), animal.getName()));
            this.hanger += animal.getWeight();
            animal.dead();
            this.energy--;
        }
        this.energy--;
    }
}
