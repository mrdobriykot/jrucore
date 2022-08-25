package creatures;

import interfaces.Mortal;
import island.Coordinates;
import island.Island;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Creature implements Mortal {
    private Coordinates coordinates;
    protected Island island;
    protected boolean isAlive = true;
    protected String name;


    public Creature(Coordinates coordinates, Island island) {
        this.coordinates = coordinates;
        this.island = island;
    }

    public Coordinates getPosition() {
        return coordinates;
    }

    public void setPosition() {
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
}
