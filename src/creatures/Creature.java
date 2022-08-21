package creatures;

import behavior.Mortal;
import creatures.animals.Animal;
import creatures.grass.Plant;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
@ToString
public abstract class Creature implements Mortal {
    Coordinates position;
    boolean isAlive;
    protected String name;
    protected double weight;
    protected static int maxCapacityInCell;
    protected int maxEnergy;
    protected AtomicInteger currentEnergy;
    protected double maxHunger;
    protected double currentHanger;
    protected int starve;

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
        if (this instanceof Animal) {
            cell.leavingOfAnimal(this);
        } else if (this instanceof Plant) {
            cell.leavingOfPlant(this);
        }
    }

    @Override
    public String toString() {
        return "{" + name +
                '}';
    }

    public int reduceEnergy() {
        return currentEnergy.decrementAndGet();
    }
    public void restoreEnergy() {
        currentEnergy.set(maxEnergy);
        currentHanger -= maxEnergy;
        if (currentHanger < 0) {
            currentHanger = 0;
            starve--;
            if (starve < 0) {
                dead();
            }
        }
    }
}
