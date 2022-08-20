package creatures.animals.carnivoreanimals;

import creatures.animals.Animal;
import island.Cell;
import island.Coordinates;
import island.Island;

import java.util.Comparator;

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
    }
}
