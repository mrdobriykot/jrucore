package settings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
