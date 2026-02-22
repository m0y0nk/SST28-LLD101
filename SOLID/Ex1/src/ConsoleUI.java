public class ConsoleUI {
    public void print(StudentRecord rec) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + rec.id);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
