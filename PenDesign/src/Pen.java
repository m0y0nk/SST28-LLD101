public abstract class Pen {
    String color;
    int refill_per;
    int refill_loss_per_char;
    boolean isOpen;
    RefillBehaviour refillBehaviour;
    OpenStrategy openStrategy;

    Pen(String color, OpenStrategy openStrategy, int refill_loss_per_char) {
        this.color = color;
        this.refill_per = 100;
        this.isOpen = false;
        this.openStrategy = openStrategy;
        this.refill_loss_per_char = refill_loss_per_char;
    }

    public void start() {
        openStrategy.start();
        isOpen = true;
    }

    public void write(String s) {
        if(!isOpen) throw new IllegalStateException("pen is closed");
        if(refill_per <= 0) throw new IllegalStateException("refill per <= 0");
        dowrite(s);
    }

    public abstract void dowrite(String s);

    public void print(String s) {
        for(int i=0; i<s.length(); i++) {
            if(refill_per <= 0) {
                System.out.print("Oops, refill got over");
                return;
            }
            System.out.print(s.charAt(i));
            refill_per -= this.refill_loss_per_char;
        }
        System.out.println();
    }

    public void close() {
        openStrategy.close();
        isOpen = false;
    }

    public void refill(String color) {
        refillBehaviour.refill();
        refill_per = 100;
        this.color = color;
    }
}