public class PrinterUtil {
    public void static print(IEntity entity, int newPos) {
        if(entity instanceof Snake) {
            System.out.println("Oops, got cut by snake, ur new position is "+newPos);
        } else {
            System.out.println("volah!, got up stairs by ladder, the new position is "+newPos);
        }
    }
}