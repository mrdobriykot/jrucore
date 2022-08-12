package creatures;

public abstract class Creatures {
    int [][] position;

    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    protected Creatures(int[][] position) {
        this.position = position;
    }
}
