package creatures.animals.carnivoreanimals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends CarnivoreAnimal{

    public Bear(int x, int y) {
        super(x, y);
    }

    {
        name = "Медведь";
        weight = 500;
        maxCapacityInCell = 5;
        energy = 2;
        hanger = 80;
    }
}
