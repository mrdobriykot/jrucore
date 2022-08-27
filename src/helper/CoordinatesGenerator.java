package helper;

import island.Coordinates;
import island.Island;

public class CoordinatesGenerator {
    private static final Island island = Island.getInstance();

    public static Coordinates generateCoordinates() {
        int generatedX = Randomizer.random(0, island.getWidth());
        int generatedY = Randomizer.random(0, island.getHeight());
        return new Coordinates(generatedX, generatedY);
    }
}
