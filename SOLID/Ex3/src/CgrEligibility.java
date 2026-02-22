public class CgrEligibility implements Eligibility {
    @Override
    public EligibilityResult checkEligibility(StudentProfile s) {
        return (s.cgr < 8.0) ? new EligibilityResult("NOT_ELIGIBLE", "CGR below 8.0")
                : new EligibilityResult("ELIGIBLE", "");
    }
}
