package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)

        List<String> tags = new ArrayList<>();
        tags.add("NEW");

        IncidentTicket t = new IncidentTicket.Builder()
                .setId(id)
                .setReporterEmail(reporterEmail)
                .setTitle(title)
                .setPriority("MEDIUM")
                .setSource("CLI")
                .setCustomerVisible(false)
                .setTags(tags)
                .build();

        return t;
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // BAD: mutating ticket after it has been "created"
        List<String> tags = t.getTags();
        tags.add("ESCALATED");
        IncidentTicket newTicket = new IncidentTicket.Builder()
                .from(t)
                .setPriority("CRITICAL")
                .setTags(tags)
                .build();
        return newTicket;
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation
        Validation.requireEmail(assigneeEmail, "assigneeEmail");
        return new IncidentTicket.Builder()
            .from(t)
            .setAssigneeEmail(assigneeEmail)
            .build();
    }
}
