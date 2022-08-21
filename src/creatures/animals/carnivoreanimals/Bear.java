package creatures.animals.carnivoreanimals;

import annotation.EatingChanceNumber;
import annotation.MaxCapacityInCell;
import island.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MaxCapacityInCell(5)
@EatingChanceNumber(3)
public class Bear extends CarnivoreAnimal{

    public Bear(int x, int y) {
        super(x, y);
    }

    public Bear (Coordinates coordinates) {
        super(coordinates);
    }

    {
        name = "Медведь";
        weight = 500;
        maxEnergy = 2;
        currentEnergy = maxEnergy;
        maxHunger = 80;
        currentHanger = maxHunger;
    }
}
