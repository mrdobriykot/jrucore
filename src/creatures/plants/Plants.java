package creatures.plants;

import creatures.Creature;
import interfaces.Mortal;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import settings.Settings;

@Getter
public class Plants extends Creature implements Mortal {
    int maxCapacityInCell;
    Settings settings;


    public Plants(Coordinates coordinates, Island island) {
        super(coordinates, island);
    }

    {
        name = "Plants";
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
