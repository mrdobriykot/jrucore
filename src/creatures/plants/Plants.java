package creatures.plants;

import annotation.MaxCapacity;
import creatures.Creature;
import interfaces.Mortal;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import settings.Settings;

@Getter
@MaxCapacity(200)
public class Plants extends Creature implements Mortal {
    int maxCapacityInCell;


    public Plants(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }

    {
        name = "Plant";
        weight = settings.getPlantsWeight();
        maxCapacityInCell = settings.getPlantsCapacityPerCell();
        emoji =settings.getPlantEmoji();
    }

    @Override
    public void leaveCell() {
        Cell cell = island.getCell(getPosition());
        cell.getFlora().remove(this);
        cell.getQuantityOfGrass().merge(getEmoji(), 1L, (oldVal, newVal) -> oldVal - newVal);
        if (cell.getQuantityOfGrass().get(getName()) < 0) {
            cell.getQuantityOfGrass().remove(getName());
        }
        cell.removeThis(this);
    }

    @Override
    public void die() {
        super.die();
    }
}
