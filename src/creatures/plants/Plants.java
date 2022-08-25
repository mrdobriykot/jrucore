package creatures.plants;

import creatures.Creature;
import interfaces.Mortal;
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

    }
}
