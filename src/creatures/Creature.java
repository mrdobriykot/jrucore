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
        comeToStartCell(position);
    }

    public Creature(Coordinates position) {
        this.position = position;
        comeToStartCell(position);
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public void comeToStartCell(Coordinates position) {
        Cell cell = Island.instance.getCell(position.getX(), position.getY());
        cell.addCreatureInCell(this);
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
