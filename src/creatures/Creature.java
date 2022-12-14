package creatures;

import interfaces.Mortal;
import island.Cell;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import settings.Settings;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public abstract class Creature implements Mortal {

    private Coordinates coordinates;
    protected Island island;
    protected Settings settings;
    protected boolean isAlive = true;
    protected String name;
    protected double weight;
    protected int maxEnergy;
    protected AtomicInteger currentEnergy = new AtomicInteger(0);
    protected double maxHunger;
    protected double currentHanger;
    protected int starve;
    protected int maxCapacity;
    protected Map<String, Double> luck;
    protected Cell cell;
    protected String emoji;


    public Creature(Coordinates coordinates, Island island) {
        this.coordinates = coordinates;
        this.island = island;
        settings = island.getSettings();
        cell = island.getCell(coordinates);
        setName(this.getClass().getSimpleName());
    }

    public Coordinates getPosition() {
        return coordinates;
    }

    public void setPosition(Coordinates coordinates) {
        coordinates.setX(coordinates.getX());
        coordinates.setY(coordinates.getY());
    }

    public abstract void leaveCell();

    @Override
    public void die() {
        isAlive = false;
        leaveCell();
    }

    @Override
    public String toString() {
        return "{" + name + '}';
    }

    public int reduceEnergy() {
        return currentEnergy.decrementAndGet();
    }

    public void restoreEnergy() {
        if (currentEnergy.get() <= 0) {
            currentEnergy.set(maxEnergy);
            currentHanger -= maxEnergy;
            if (currentHanger < 0) {
                currentHanger = 0;
                starve--;
                if (starve < 0) {
                    die();
                }
            }
        }
    }
}
