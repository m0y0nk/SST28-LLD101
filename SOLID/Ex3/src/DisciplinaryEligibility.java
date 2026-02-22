public class DisciplinaryEligibility implements Eligibility {
    public EligibilityResult checkEligibility(StudentProfile s) {
        return (s.disciplinaryFlag != LegacyFlags.NONE) ? new EligibilityResult("NOT_ELIGIBLE", "disciplinary flag is set")
                : new EligibilityResult("ELIGIBLE", "");
    }
}
