public class CapStrategy implements OpenStrategy {
    @Override
    public void start() {
        System.out.println("opening the cap");
    }

    @Override
    public void close() {
        System.out.println("closing the cap");
    }
}
