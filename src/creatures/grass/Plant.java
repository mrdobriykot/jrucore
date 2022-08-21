package creatures.grass;


import annotation.MaxCapacityInCell;
import creatures.Creature;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;

@MaxCapacityInCell(200)
@Getter
public class Plant extends Creature {
    int maxCapacitySell;

    public Plant(Coordinates position) {
        super(position);
    }

    public Plant(int x, int y) {
        super(x,y);
    }

    {
        name = "Растение";
        weight = 1;
        maxCapacitySell = 200;
    }
    @Override
    public void dead() {
        super.dead();
    }

    @Override
    public void leaveCell() {
        {
            Cell cell = Island.instance.getCell(getPosition());
            cell.getFlora().remove(this);
            cell.getQtyOfGrass().merge(getName(), 1L, (oldVal, newVal) -> oldVal - newVal);
            if (cell.getQtyOfGrass().get(getName()) < 0) {
                cell.getQtyOfGrass().remove(getName());
            }
            cell.removeThis(this);
        }
    }
}
