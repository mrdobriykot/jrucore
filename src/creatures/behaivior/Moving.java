package creatures.behaivior;

public interface Moving {
    default void move() {
        System.out.println("Создание двигается");
    }
}
