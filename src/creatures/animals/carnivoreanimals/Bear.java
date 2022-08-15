package creatures.animals.carnivoreanimals;

import annotation.MaxCapacity;
import island.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MaxCapacity(5)
public class Bear extends CarnivoreAnimal{

    public Bear(int x, int y) {
        super(x, y);
    }

    public Bear(Coordinates position) {
        super(position);
    }

    {
        name = "Медведь";
        weight = 500;
        energy = 2;
        hanger = 80;
    }
}
