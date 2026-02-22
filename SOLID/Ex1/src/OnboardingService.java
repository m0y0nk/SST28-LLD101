import java.util.*;

public class OnboardingService {
    private final StudentRepository db;

    public OnboardingService(StudentRepository db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        ParsingUtil parser = new ParsingUtil();
        Student student = parser.parse(raw);

        StudentValidator validator = new StudentValidator();
        List<String> errors = validator.validate(student);

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, student.getName(), student.getEmail(), student.getPhone(), student.getProgram());

        db.save(rec);

        ConsoleUI printer = new ConsoleUI();
        printer.print(rec);
    }
}
