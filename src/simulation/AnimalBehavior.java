package simulation;

import creatures.animals.Animal;
import creatures.animals.carnivoreanimals.CarnivoreAnimal;
import creatures.animals.herbivoreanimals.HerbivoreAnimal;
import island.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnimalBehavior implements Runnable{
    public Animal animal;
    protected List<Cell> accessibleCells = new ArrayList<>();

    public AnimalBehavior(Animal behavior) {
        animal = behavior;
    }

    @Override
    public void run() {
        Coordinates coordinates = animal.getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < Island.instance.getXSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < Island.instance.getYSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
        do {
            if (animal.getCurrentHanger() > animal.getCurrentHanger() / 2) {
                List<Animal> animalToBreed = chooseForBreed();
                if (!animalToBreed.isEmpty()) {
                    animal.breed(animalToBreed.get(0));
                } else {
                    animal.moveTo(choosingDirection());
                }
            } else if (animal.getCurrentHanger() < animal.getCurrentHanger()/2 && animal.getCurrentEnergy() > 0) {
                animal.eat();
            }
        } while (animal.getCurrentEnergy() > 1);
    }



    public Cell choosingDirection() {
        if(animal instanceof CarnivoreAnimal) { System.out.println(this + " выбирает направление");
            return accessibleCells.stream()
                    .max(Comparator.comparing(Cell::getHerbivoreQty))
                    .orElse(Island.instance.getCell(animal.getPosition())); }
        else if (animal instanceof HerbivoreAnimal) {
            return accessibleCells.stream()
                    .min(Comparator.comparing(Cell::getCarnivoreQty))
                    .orElse(Island.instance.getCell(animal.getPosition()));
        }
        else throw new RuntimeException("Неправильно задан тип животного");
    }

    public List<Animal> chooseForBreed() {
        Cell cell = Island.instance.getCell(animal.getPosition());
        return cell.getFauna().stream().filter(e -> e.getName()
                .equals(animal.getName()) && !(e.equals(animal))).toList();
    }


}
