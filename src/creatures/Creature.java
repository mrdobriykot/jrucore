package creatures;

import behavior.Mortal;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Creature implements Mortal {
    Coordinates position;
    boolean isAlive;
    protected String name;

    protected Creature (int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public Creature(Coordinates position) {
        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    @Override
    public void dead() {
        Mortal.super.dead();
        isAlive = false;
    }

    @Override
    public String toString() {
        return "{" + name +
                '}';
    }
}
