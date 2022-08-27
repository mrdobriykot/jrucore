package helper;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int random(int leftBound, int rightBound) {
        return ThreadLocalRandom.current().nextInt(leftBound, rightBound);
    }
}
