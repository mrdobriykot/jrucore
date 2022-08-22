package helper;

import island.Coordinates;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class CoordinatesGenerator {
    public static Coordinates generateCoordinates() {
        int generatedX = ThreadLocalRandom.current().nextInt(0, Island.getInstance().getXSize());
        int generatedY = ThreadLocalRandom.current().nextInt(0, Island.getInstance().getYSize());
        return new Coordinates(generatedX, generatedY);
    }
}
