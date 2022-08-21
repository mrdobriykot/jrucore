package behavior;

public interface Mortal {
    default void dead() {
        //System.out.println(this + "умер");
    }
}
