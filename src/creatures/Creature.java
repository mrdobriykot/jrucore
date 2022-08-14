package creatures;

import behaivior.Mortal;
import field.Cell;
import field.Coordinates;
import field.Field;
import lombok.ToString;

@ToString
public abstract class Creature implements Mortal {
    Coordinates position;
    boolean isAlive;

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
        Cell cell = Field.instance.getCell(position.getX(), position.getY());
        cell.addCreatureInCell(this);
    }

    @Override
    public void dead() {
        Mortal.super.dead();
        isAlive = false;
    }
}
