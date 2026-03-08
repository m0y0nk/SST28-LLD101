package com.example.reports;

/**
 * TODO (student):
 * Extract expensive loading logic from ReportFile into this RealSubject.
 */
public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final ReportFile rf;

    public RealReport(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
        rf = new ReportFile(reportId, title, classification);
    }

    @Override
    public void display(User user) {
        rf.display(user);
    }


    public String getClassification() {
        return classification;
    }
}
