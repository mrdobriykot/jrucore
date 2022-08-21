package simulation;

import island.Cell;
import island.Island;

public class BeginNewDay implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                cell.getFauna().stream().forEach(e -> {
                    e.setCurrentEnergy(e.getMaxEnergy());
                    e.setCurrentHanger(e.getCurrentHanger() - e.getMaxEnergy());
                    if (e.getCurrentHanger() < 0) {
                        e.setCurrentHanger(0);
                        e.setStarve(e.getStarve() - 1);
                    }
                });
            }
        }
    }
}
