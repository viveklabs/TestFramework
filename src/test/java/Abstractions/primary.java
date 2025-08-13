package Abstractions;

public class primary extends ActionAbstract implements ActionInterface{

    public static void main(String[] args) {

        primary p = new primary();
        p.getJam();
        p.getChar();
        /*((ActionInterface)p).i = 46;*/
        System.out.println(ActionInterface.i);
        System.out.println(p.j);
        p.getprint();
        p.checkprint();
        p.getPu();
        p.getres();
        p.getYes();
    }
    @Override
    void getJam() {
        System.out.println("This is primary overriden method from abs");
    }

    @Override
    public void getChar() {
        System.out.println("This is overriden method from Interface");
    }
}
