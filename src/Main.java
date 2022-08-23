import island.Island;
import settings.Settings;

public class Main {
    public static void main(String[] args) {
        System.out.println("Длина острова равна " + Island.getInstance().getWidth());
        System.out.println("Ширина острова равна " + Island.getInstance().getHeight());
        Island.getInstance().initIsland();
        System.out.println(Island.getInstance().getCell(1, 1).getClass());


    }
}
