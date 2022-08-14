package behaivior;

public interface Mortal {
    default void dead() {
        System.out.println(this + "умер");
    }
}
