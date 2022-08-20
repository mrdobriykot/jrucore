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
    protected double weight;
    protected static int maxCapacityInCell;
    protected int energy;
    protected double hanger;

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

    public void setPosition(Coordinates coordinates) {
        position.setX(coordinates.getX());
        position.setY(coordinates.getY());
    }

    @Override
    public void dead() {
        Mortal.super.dead();
        isAlive = false;
        leaveCell();
    }

    public synchronized void leaveCell() {
        Cell cell =  Island.instance.getCell(this.getPosition());
        cell.getFauna().remove(this);
        Integer qtyOfAnimals = cell.getCurrentCapacityOfCell().get(this.getName());
        cell.getCurrentCapacityOfCell().put(this.getName(), qtyOfAnimals - 1);
    }

    @Override
    public String toString() {
        return "{" + name +
                '}';
    }
}
