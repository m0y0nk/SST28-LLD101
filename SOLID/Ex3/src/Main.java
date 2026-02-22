import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), List.of(
                new CgrEligibility(),
                new AttendanceEligibility(),
                new CreditsEligibility(),
                new DisciplinaryEligibility()
        ));
        engine.runAndPrint(s);
    }
}
