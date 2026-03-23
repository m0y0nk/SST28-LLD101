public class Main {
    public static void main(String[] args) {
        Pen p = PenFactory.create("ball point", "red", true);
        p.start();
        p.write("Hello, My name is Mayank Soni and this is the demonstration of the pen design !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        p.close();

        p.refill("blue");

        p.start();
        p.write("I guess now the refill would have filled completely");
        p.close();
    }
}
