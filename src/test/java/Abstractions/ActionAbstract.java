package Abstractions;

public abstract class ActionAbstract implements ActionInterface {

    int j = 33;
    int i = 11;

    abstract void getJam();

    private void getfruit() {
        System.out.println("This is private Abstract method");
    }
    protected void getres() {
        System.out.println("This is protected  abstract methid");
    }

    void getYes() {
        System.out.println("This is package private Abstract method");
    }

    public void getPu() {
        System.out.println("This is public abs method");
    }

}
