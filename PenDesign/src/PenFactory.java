public class PenFactory {
    public static Pen create(String type, String color, boolean withCap) {
        if(type.equalsIgnoreCase("Fountain")) {
            if(withCap) return new Fountain(color, new CapStrategy());
            else return new Fountain(color, new ClickStrategy());
        } else if(type.equalsIgnoreCase("Ball Point")) {
            if(withCap) return new BallPoint(color, new CapStrategy());
            else return new BallPoint(color, new ClickStrategy());
        } else {
            if(withCap) return new Gel(color, new CapStrategy());
            else return new Gel(color, new ClickStrategy());
        }
    }
}
