public class BallPoint extends Pen {

    BallPoint(String color, OpenStrategy openStrategy) {
        super(color, openStrategy, 1);
        this.refillBehaviour = new Interchangable();
    }

    @Override
    public void dowrite(String s) {
        System.out.println("Writing with "+color+" color, using BallPoint Pen :");
        super.print(s);
    }
}
