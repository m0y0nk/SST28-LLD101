public class ClickStrategy implements OpenStrategy {
    @Override
    public void start() {
        System.out.println("click click! opened");
    }

    @Override
    public void close() {
        System.out.println("click click! closed");
    }
}
