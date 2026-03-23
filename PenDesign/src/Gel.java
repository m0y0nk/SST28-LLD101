public class Gel extends Pen {

    Gel(String color, OpenStrategy openStrategy) {
        super(color, openStrategy, 2);
        this.refill_loss_per_char = 2;
        this.refillBehaviour = new Interchangable();
    }

    @Override
    public void dowrite(String s) {
        System.out.println("Writing with "+color+" color, using Gel Pen :");
        super.print(s);
    }
}
