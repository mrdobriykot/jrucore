package behavior;

import creatures.animals.Animal;

public interface Breeding {
    Animal chooseForBreed();
    void breed(Animal animal);
}
