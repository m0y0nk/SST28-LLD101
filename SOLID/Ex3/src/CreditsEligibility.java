public class CreditsEligibility implements Eligibility {
    public EligibilityResult checkEligibility(StudentProfile s) {
        return (s.earnedCredits < 20) ? new EligibilityResult("NOT_ELIGIBLE", "credits below 20")
                : new EligibilityResult("ELIGIBLE", "");
    }
}

