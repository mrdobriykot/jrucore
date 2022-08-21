package creatures.animals.herbivoreanimals;

import annotation.EatingChanceNumber;
import creatures.animals.Animal;
import creatures.grass.Plant;
import helper.EatingChance;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;
import java.util.List;

public abstract class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates position) {
        super(position);
    }

    public HerbivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public void eat() {
        Cell cell = Island.instance.getCell(this.getPosition());
        List<Animal> list = cell.getFauna().stream().filter(e -> EatingChance.getEatingChance(this
                                .getClass()
                                .getAnnotation(EatingChanceNumber.class)
                                .value(),
                        e.getClass()
                                .getAnnotation(EatingChanceNumber.class).value()) > 0)
                .toList();
        if (!list.isEmpty()) {
            Animal victim = chooseVictim();
            this.tryToEat(victim);
        } else  if (!cell.getFlora().isEmpty()){
            Plant plant = cell.getFlora().stream().findAny().get();
            plant.dead();
            currentHanger +=10;
            if (currentHanger > maxHunger) {
                currentHanger = maxHunger;
            }
        }
        reduceEnergy();
    }
}
