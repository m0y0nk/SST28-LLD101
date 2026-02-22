public class AttendanceEligibility implements Eligibility {
    @Override
    public EligibilityResult checkEligibility(StudentProfile s) {
        return (s.attendancePct < 75) ? new EligibilityResult("NOT_ELIGIBLE", "attendance below 75")
                : new EligibilityResult("ELIGIBLE", "");
    }
}
