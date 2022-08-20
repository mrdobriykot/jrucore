package creatures.animals.herbivoreanimals;

import creatures.animals.Animal;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;

public abstract class HerbivoreAnimal extends Animal {

    public HerbivoreAnimal(Coordinates position) {
        super(position);
    }

    public HerbivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public Cell chooseDirection() {
        System.out.println(this + " выбирает направление");

        return this.getAccessibleCell().stream()
                .min(Comparator.comparing(Cell::getCarnivoreQty))
                .orElseGet(() -> Island.instance.getCell(this.getPosition()));
    }
}
