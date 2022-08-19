package helper;

import island.Coordinates;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class CoordinatesGenerator {
    public static Coordinates generateCoordinates() {
        int generetedX = ThreadLocalRandom.current().nextInt(0, Island.instance.getXSize());
        int generatedY = ThreadLocalRandom.current().nextInt(0, Island.instance.getYSize());
        return new Coordinates(generetedX, generatedY);
    }
}
