package creatures.animals.carnivoreanimals;

import annotation.MaxCapacityInCell;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MaxCapacityInCell(5)
public class Bear extends CarnivoreAnimal{

    public Bear(int x, int y) {
        super(x, y);
    }

    {
        name = "Медведь";
        weight = 500;
        energy = 2;
        hanger = 80;
    }
}
