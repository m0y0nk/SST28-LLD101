package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public final class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final String priority;       // LOW, MEDIUM, HIGH, CRITICAL
    private final List<String> tags;     // mutable leak
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;    // optional
    private final String source;  // e.g. "CLI", "WEBHOOK", "EMAIL"

    private IncidentTicket(Builder builder) {
        this.id = builder.id;
        Validation.requireTicketId(this.id);

        this.reporterEmail = builder.reporterEmail;
        Validation.requireEmail(this.reporterEmail, "reporterEmail");

        this.title = builder.title;
        Validation.requireNonBlank(this.title, "title");

        this.description = builder.description;
        this.priority = builder.priority;
        this.tags = List.copyOf(builder.tags);
        this.assigneeEmail = builder.assigneeEmail;
        this.customerVisible = builder.customerVisible;
        this.slaMinutes = builder.slaMinutes;
        this.source = builder.source;
    }

    static class Builder {
        String id;
        String reporterEmail;
        String title;
        String description;
        String priority;       // LOW, MEDIUM, HIGH, CRITICAL
        List<String> tags;     // mutable leak
        String assigneeEmail;
        boolean customerVisible;
        Integer slaMinutes;    // optional
        String source;  

        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Builder setReporterEmail(String reporterEmail) {
            this.reporterEmail = reporterEmail;
            return this;
        }
        public Builder setTitle(String title) {
            this.title = title; 
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setPriority(String priority) {
            this.priority = priority;
            return this;
        }
        public Builder setTags(List<String> tags) {
            this.tags = new ArrayList<>(tags);
            return this;
        }
        public Builder setAssigneeEmail(String assigneeEmail) {
            this.assigneeEmail = assigneeEmail;
            return this;
        }
        public Builder setCustomerVisible(boolean customerVisible) {
            this.customerVisible = customerVisible;
            return this;
        }
        public Builder setSlaMinutes(Integer slaMinutes) {
            this.slaMinutes = slaMinutes;
            return this;
        }
        public Builder setSource(String source) {
            this.source = source;
            return this;
        }

        public IncidentTicket build() {
            return new IncidentTicket(this);
        }

        public Builder from(IncidentTicket t) {
            this.id = t.getId();
            this.reporterEmail = t.getReporterEmail();
            this.title = t.getTitle();
            this.description = t.getDescription();
            this.priority = t.getPriority();
            this.tags = new ArrayList<>(t.getTags());
            this.assigneeEmail = t.getAssigneeEmail();
            this.customerVisible = t.isCustomerVisible();
            this.slaMinutes = t.getSlaMinutes();
            this.source = t.getSource();
            return this;
        }
    }

    // Getters
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() { return List.copyOf(tags); } // BROKEN: leaks internal list
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }
}
