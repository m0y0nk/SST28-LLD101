import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<Eligibility> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<Eligibility> rules) { 
        this.store = store;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for(Eligibility r : rules) {
            EligibilityResult r1 = r.checkEligibility(s);
            if (r1.getStatus().equals("NOT_ELIGIBLE")) {
                status = "NOT_ELIGIBLE";
                reasons.add(r1.getReason());
                break;
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
