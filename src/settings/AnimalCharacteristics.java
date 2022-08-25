package settings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalCharacteristics {
    private String name;
    private double weight;
    private int maxEnergy;
    private int currentEnergy;
    private double maxHunger;
    private double currentHunger;
    private int maxCapacity;
    private String emoji;
}
