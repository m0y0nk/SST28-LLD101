public class Fountain extends Pen {

    Fountain(String color, OpenStrategy openStrategy) {
        super(color, openStrategy, 3);
        this.refillBehaviour = new Fillable();
    }
    @Override
    public void dowrite(String s) {
        System.out.println("Writing with "+color+" color, using Fountain Pen :");
        super.print(s);
    }
}
