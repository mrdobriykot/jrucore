package creatures;

import field.Coordinates;

public abstract class Creature {
    int [][] position;

    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    protected Creature(Coordinates position) {
        this.position = position;
    }
}
