package Abstractions;

public interface ActionInterface {

    void getChar();
    int i = 20;

    default void getprint() {
        System.out.println("This is default method");
    }

    default boolean checkprint() {
        System.out.println("This is default boolean method");
        return true;
    }
}
