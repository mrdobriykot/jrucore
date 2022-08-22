package simulation;

import island.Cell;
import island.Island;

public class BeginNewDay implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < Island.getInstance().getXSize(); i++) {
            for (int j = 0; j < Island.getInstance().getYSize(); j++) {
                Cell cell = Island.getInstance().getCell(i, j);
                cell.getFauna().stream().forEach(e -> {
                    e.getCurrentEnergy().set(e.getMaxEnergy());
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
