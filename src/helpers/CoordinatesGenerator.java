package helpers;

import island.Coordinates;
import island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class CoordinatesGenerator {
    public static Coordinates generateCoordinates() {
        int generateX = ThreadLocalRandom.current().nextInt(0, Island.instance.getXSize());
        int generateY = ThreadLocalRandom.current().nextInt(0, Island.instance.getYSize());
        return new Coordinates(generateX, generateY);
    }
}
