package behavior;

public interface Breeding {
    default void breed() {
        System.out.println(String.format("%s размножился", this));
    }
}
